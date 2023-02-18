import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static final String BOIDI_WIDTH_FROM_INPUT = "867";
    public static final String BOIDI_WIDTH_FROM_OUTPUT = "1068";
    public static final String ANNOTATIONS_WIDTH = "400";
    public static Gson gson = new Gson();

    public static void main(String[] args) throws JsonProcessingException {


        XmlMapper xmlMapper = new XmlMapper();
//        if (getRuleFromJson(getRoleProject()).getConditional().equals("AND") || getRuleFromJsonList(getRuleProjectList()).size() == 1) {
//            System.out.println(xmlMapper.writeValueAsString(getDefinition
//                    (getRuleFromJson(getRoleProject()))));
//        } else {
//        System.out.println(xmlMapper.writeValueAsString(getDMNDiagram("1")));
        System.out.println(xmlMapper
                .writeValueAsString(getDefinitionFromList(getRuleFromJsonList(getRuleProjectList()))));
//        }
    }

    //Постоянный метод для всех
    public static Definitions getDefinitionFromList(List<RuleFromJson> fromJsonList) {
        Definitions definitions = new Definitions();
        definitions.setDecision(getDecisionFromList(fromJsonList));
        definitions.setDmndi(getDmndi(definitions.getDecision().getId()));
        return definitions;
    }

    //Постоянный метод для всех
    public static Decision getDecisionFromList(List<RuleFromJson> ruleFromJsonList) {
        Decision decision = new Decision();
        decision.setId("dmn_" + UUID.randomUUID());
        decision.setName(ruleFromJsonList.get(0).getActionList().get(0).getActionType().toUpperCase());
        decision.setDecisionTable(getDecisionTableTwo(ruleFromJsonList));
        return decision;
    }

    //Метод для 2 json OR
    public static DecisionTable getDecisionTableTwo(List<RuleFromJson> ruleFromJson) {
        DecisionTable table = new DecisionTable();
        table.setId("DecisionTable_" + UUID.randomUUID());
        table.setHitPolicy("FIRST");
        table.setBiodiAnnotationsWidth(ANNOTATIONS_WIDTH);
        if (ruleFromJson.get(0).getConditional().equalsIgnoreCase("AND")) {
            List<RuleXml> ruleXmlList = new ArrayList<>();
            ruleXmlList = ruleFromJson.stream()
                    .map(Application::getRuleXml)
                    .toList();
            table.setRule(ruleXmlList);
            table.setOutput(getOutput(ruleFromJson.get(0)));
            table.setInput(getInput(ruleFromJson.get(0)));
        }else {
            List<List<RuleCriteria>> list =
                    ruleFromJson.stream()
                            .map(RuleFromJson::getRuleCriteriaList).toList();
            List<RuleCriteria> list1 = new ArrayList<>();
            list.forEach(list1::addAll);

            RuleFromJson rule = new RuleFromJson();
            rule.setConditional(ruleFromJson.get(0).getConditional());

            List<List<Action>> actionList = ruleFromJson.stream()
                    .map(RuleFromJson::getActionList).toList();
            List<Action> actions = new ArrayList<>();
            actionList.forEach(actions::addAll);

            rule.setActionList(actions);


            rule.setRuleCriteriaList(list1);


            List<List<Input>> inputList = ruleFromJson.stream()
                    .map(Application::getInput).toList();
            List<Input> inputs = new ArrayList<>();
            inputList.forEach(inputs::addAll);
            if (ruleFromJson.size() > 1) {
                List<Input> inputs2 = new ArrayList<>();
                inputs2.add(inputs.get(0));
                for (int i = 0; i <= inputs.size() - 1; i++) {

                    for (int j = 0; j <= inputs2.size() - 1; ) {
                        if (!inputs.get(i).getLabel().equals(inputs2.get(j).getLabel())) {
                            inputs2.add(inputs.get(i));
                        } else {
                            i++;
                        }
                        break;
                    }
                }
                table.setRule(getRuleXmlList(rule, inputs2.size(), actionList.size()));
                table.setInput(inputs2);
            } else {
                table.setRule(getRuleXmlList(rule, inputs.size(), actionList.size()));
                table.setInput(inputs);
            }
            table.setOutput(getOutput(rule));
        }
        return table;
    }

    //Работает на 1 json OR(Two) и 2 json AND (fromList)
    public static List<RuleXml> getRuleXmlList(RuleFromJson rule, int size, int actionSize) {
        List<RuleXml> ruleXmlList = new ArrayList<>();
        int count = 0;
        int countAll = 0;
        for (RuleCriteria r : rule.getRuleCriteriaList()) {
            RuleXml ruleXml = new RuleXml();
            ruleXml.setId("DecisionRule_" + UUID.randomUUID());

            List<List<Action>> actionList = rule.getActionList().stream()
                    .map(action -> {
                        List<Action> actions = new ArrayList<>();
                        actions.add(action);
                        return actions;
                    }).toList();
            List<InputEntry> list;
            List<OutputEntry> outputEntries;
            count++;
            countAll++;
            if (size != 0) {
                if (count > size) {
                    count = 1;

                    //второй лист акций
                }
                list = getInputEntryForOr(r, count, size);
                if (countAll <= size || actionSize == 1) {
                    outputEntries = getOutputEntryTow(actionList.get(0));
                    ruleXml.setDescription(rule.getActionList().get(0).getActionType() +
                            " " + rule.getActionList().get(0).getField() +
                            " " + rule.getActionList().get(0).getValue());
                    //первый лист акций
                } else {
                    outputEntries = getOutputEntryTow(actionList.get(1));
                    ruleXml.setDescription(rule.getActionList().get(1).getActionType() +
                            " " + rule.getActionList().get(1).getField() +
                            " " + rule.getActionList().get(1).getValue());
                }

            } else {

                list = getInputEntryForOr(r, count, size);
                outputEntries = getOutputEntry(rule);
            }
            ruleXml.setInputEntry(list);
            ruleXml.setOutputEntry(outputEntries);
            ruleXmlList.add(ruleXml);
        }

        return ruleXmlList;
    }

    public static List<OutputEntry> getOutputEntryTow(List<Action> actions) {
        List<OutputEntry> o = new ArrayList<>();
        for (Action a : actions) {
            OutputEntry outputEntry = new OutputEntry();
            outputEntry.setId("LiteralExpression_" + UUID.randomUUID());
            outputEntry.setText(a.getActionType() + " "
                    + a.getValue() + " "
                    + a.getOperator() + " "
                    + a.getField());
            o.add(outputEntry);
        }
        return o;
    }

    public static InputEntry getInputEntry(RuleCriteria ruleCriteria) {

        InputEntry i = new InputEntry();
        i.setId("UnaryTests_" + UUID.randomUUID());
        if (ruleCriteria.getType().equals("string")) {
            i.setText("\"" + ruleCriteria.getValue() + "\"");//"Условие для начисления");
        } else if (ruleCriteria.getType().equals("number")) {
            i.setText(ruleCriteria.getOperator() + ruleCriteria.getValue().toString());
        }

        return i;
    }

    //Работает на 1 json AND(fromList)
    public static RuleXml getRuleXml(RuleFromJson rule) {
        RuleXml ruleXml = new RuleXml();
        ruleXml.setId("DecisionRule_" + UUID.randomUUID());
        ruleXml.setDescription(rule.getActionList().get(0).getActionType() +
                " " + rule.getActionList().get(0).getField() +
                " " + rule.getActionList().get(0).getValue());
        List<InputEntry> inputEntryList = new ArrayList<>();
        for (RuleCriteria r : rule.getRuleCriteriaList()) {
            inputEntryList.add(getInputEntry(r));
            ruleXml.setInputEntry(inputEntryList);
            ruleXml.setOutputEntry(getOutputEntry(rule));
        }

        return ruleXml;
    }

    public static List<InputEntry> getInputEntryForOr(RuleCriteria ruleCriteria, int count, int size) {
        List<InputEntry> inputEntryList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            inputEntryList.add(new InputEntry("", "UnaryTests_" + UUID.randomUUID()));
        }

        InputEntry i = inputEntryList.get(count - 1);
        if (ruleCriteria.getType().equals("string")) {
            i.setText("\"" + ruleCriteria.getValue() + "\"");//"Условие для начисления");
        } else if (ruleCriteria.getType().equals("number")) {
            i.setText(ruleCriteria.getOperator() + ruleCriteria.getValue().toString());
        }
        return inputEntryList;
    }


    public static List<OutputEntry> getOutputEntry(RuleFromJson rule) {
        List<OutputEntry> o = new ArrayList<>();
        for (Action a : rule.getActionList()) {
            OutputEntry outputEntry = new OutputEntry();
            outputEntry.setId("LiteralExpression_" + UUID.randomUUID());
            outputEntry.setText(a.getActionType() + " "
                    + a.getValue() + " "
                    + a.getOperator() + " "
                    + a.getField());
            o.add(outputEntry);
        }
        return o;
    }

    public static List<Input> getInput(RuleFromJson rule) {

        return rule.getRuleCriteriaList()
                .stream()
                .map(ruleCriteria -> {
                    String label = ruleCriteria.getField();

                    String variable = ruleCriteria.getField();
                    Input input = new Input();
                    input.setId("Input_" + UUID.randomUUID());
                    input.setLabel(label);
                    input.setInputExpression(getInputExpression(ruleCriteria));
                    input.setBiodiWidth(BOIDI_WIDTH_FROM_INPUT);
                    input.setCamundaInputVariable(variable);
                    return input;
                }).toList();
    }

    public static InputExpression getInputExpression(RuleCriteria rule) {
        InputExpression expression = new InputExpression();
        expression.setId("InputExpression_" + UUID.randomUUID());
        expression.setTypeRef(rule.getType());
        expression.setText(rule.getEntity()
                + " " + rule.getField());
        return expression;
    }

    public static Output getOutput(RuleFromJson rule) {
        Output output = new Output();
        output.setId("Output_" + UUID.randomUUID());
        output.setLabel(rule.getActionList().get(0).getActionType().toUpperCase());
        output.setTypeRef(" ");
        output.setBiodiWidth(BOIDI_WIDTH_FROM_OUTPUT);
        output.setName(rule.getActionList().get(0).getActionType());
        return output;
    }

    public static List<RuleProject> getRuleProjectList() {
        List<RuleProject> listRuleProject = new ArrayList<>();
        RuleProject ruleProject = new RuleProject(1L, 1L, "Правило №2",
                1, "{\n" +
                "  \"condition\": \"OR\",\n" +
                "  \"rules\": [\n" +
                "    {\n" +
                "      \"entity\": \"product\",\n" +
                "      \"field\": \"group\",\n" +
                "      \"operator\": \"=\",\n" +
                "      \"type\": \"string\",\n" +
                "      \"value\": \"молочные продукты\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"entity\": \"order\",\n" +
                "      \"field\": \"partner\",\n" +
                "      \"operator\": \"=\",\n" +
                "      \"type\": \"string\",\n" +
                "      \"value\": \"Рога и копыта\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"entity\": \"order\",\n" +
                "      \"field\": \"price\",\n" +
                "      \"operator\": \"=\",\n" +
                "      \"type\": \"number\",\n" +
                "      \"value\": 1200\n" +
                "    }\n" +
                "  ],\n" +
                "  \"actions\": [\n" +
                "    {\n" +
                "      \"field\": \"miles\",\n" +
                "      \"value\": 5,\n" +
                "      \"actionType\": \"accrual\",\n" +
                "      \"operator\": \"qual\",\n" +
                "      \"type\": \"value\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n", 112L, OffsetDateTime.now(),
                null, null, true);
        RuleProject ruleProject1 = new RuleProject(2L, 1L, "Правило №3",
                1, "{\n" +
                "  \"condition\": \"AND\",\n" +
                "  \"rules\": [\n" +
                "    {\n" +
                "      \"entity\": \"order\",\n" +
                "      \"field\": \"partner\",\n" +
                "      \"operator\": \"=\",\n" +
                "      \"type\": \"string\",\n" +
                "      \"value\": \"Ромашка\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"entity\": \"product\",\n" +
                "      \"field\": \"group\",\n" +
                "      \"operator\": \"=\",\n" +
                "      \"type\": \"string\",\n" +
                "      \"value\": \"Цветы живые\" \n" +
                "    },\n" +
                "    {\n" +
                "      \"entity\": \"order\",\n" +
                "      \"field\": \"price\",\n" +
                "      \"operator\": \"=>\",\n" +
                "      \"type\": \"number\",\n" +
                "      \"value\": 200\n" +
                "    }\n" +
                "  ],\n" +
                "  \"actions\": [\n" +
                "    {\n" +
                "      \"field\": \"miles\",\n" +
                "      \"value\": 25,\n" +
                "      \"actionType\": \"accrual\",\n" +
                "      \"operator\": \"nonQual\",\n" +
                "      \"type\": \"value\"\n" +
                "    }\n" +
                "  ]\n" +
                "}", 112L, OffsetDateTime.now(),
                null, null, true);
        listRuleProject.add(ruleProject);
        listRuleProject.add(ruleProject1);
        return listRuleProject;
    }

    public static List<RuleFromJson> getRuleFromJsonList(List<RuleProject> ruleProjectList) {
        return ruleProjectList.stream()
                .map(ruleProject -> gson.fromJson(ruleProject.getCriteriaAndAction(), RuleFromJson.class)).toList();
    }

    public static Dmndi getDmndi(String id) {
        Dmndi dmndi = new Dmndi();
        dmndi.setDMNDiagram(getDMNDiagram(id));
        return dmndi;
    }

    public static DMNDiagram getDMNDiagram(String id) {
        DMNDiagram dMNDiagram = new DMNDiagram();
        dMNDiagram.setDMNShape(getDMNShape(id));
        return dMNDiagram;
    }

    public static DMNShape getDMNShape(String id) {
        DMNShape shape = new DMNShape();
        shape.setBounds(new Bounds());
        shape.setDmnElementRef(id);
        return shape;
    }
}
