import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Definitions {
    @SerializedName("decision")
    @Expose
    private Decision decision;
    @SerializedName("DMNDI")
    @Expose
    @JacksonXmlProperty(localName = "dmndi:DMNDI")
    private Dmndi dmndi;
    @SerializedName("_xmlns")
    @Expose
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns")
    private String xmlns;
    @SerializedName("_xmlns:dmndi")
    @Expose
    @JacksonXmlProperty(localName = "xmlns:dmndi", isAttribute = true)
    private String xmlnsDmndi;
    @SerializedName("_xmlns:dc")
    @Expose
    @JacksonXmlProperty(localName = "xmlns:dc", isAttribute = true)
    private String xmlnsDc;
    @SerializedName("_xmlns:modeler")
    @Expose
    @JacksonXmlProperty(localName = "xmlns:modeler", isAttribute = true)
    private String xmlnsModeler;
    @SerializedName("_xmlns:biodi")
    @Expose
    @JacksonXmlProperty(localName = "xmlns:biodi", isAttribute = true)
    private String xmlnsBiody;
    @SerializedName("_xmlns:camunda")
    @Expose
    @JacksonXmlProperty(localName = "xmlns:camunda", isAttribute = true)
    private String xmlCamunda;
//    @SerializedName("_id")
//    @Expose
//    @JacksonXmlProperty(isAttribute = true)
//    private String id;

    @SerializedName("_name")
    @Expose
    @JacksonXmlProperty(isAttribute = true, localName = "name")
    private String name;

    @SerializedName("_namespace")
    @Expose
    @JacksonXmlProperty(isAttribute = true, localName = "namespace")
    private String namespace ;
    @SerializedName("_exporter")
    @Expose
    @JacksonXmlProperty(isAttribute = true, localName = "exporter")
    private String exporter;
    @SerializedName("_exporterVersion")
    @Expose
    @JacksonXmlProperty(isAttribute = true, localName = "exporterVersion")
    private String exporterVersion;
    @SerializedName("_modeler:executionPlatform")
    @Expose
    @JacksonXmlProperty(isAttribute = true, localName = "modeler:executionPlatform")
    private String modelerExecutionPlatform;
    @SerializedName("_modeler:executionPlatformVersion")
    @Expose
    @JacksonXmlProperty(isAttribute = true, localName = "modeler:executionPlatformVersion")
    private String  modelerExecutionPlatformVersion;

    public Definitions() {
        modelerExecutionPlatformVersion = "7.17.0";
        modelerExecutionPlatform ="Camunda Platform";
        exporterVersion = "5.0.0";
        exporter = "Camunda Modeler";
        name= "DRD";
//        id = "Definitions_" + UUID.randomUUID();
        namespace = "http://camunda.org/schema/1.0/dmn";
        xmlCamunda = "http://camunda.org/schema/1.0/dmn";
        xmlnsBiody = "http://bpmn.io/schema/dmn/biodi/2.0";
        xmlnsModeler = "http://camunda.org/schema/modeler/1.0";
        xmlnsDc ="http://www.omg.org/spec/DMN/20180521/DC/";
        xmlnsDmndi = "https://www.omg.org/spec/DMN/20191111/DMNDI/";
        xmlns = "https://www.omg.org/spec/DMN/20191111/MODEL/";
    }

    public Definitions(Decision decision, Dmndi dmndi) {
       this.decision = decision;
       this.dmndi = dmndi;
    }

    public Decision getDecision() {
        return decision;
    }

    public void setDecision(Decision decision) {
        this.decision = decision;
    }

    public Dmndi getDmndi() {
        return dmndi;
    }

    public void setDmndi(Dmndi dmndi) {
        this.dmndi = dmndi;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getXmlnsDmndi() {
        return xmlnsDmndi;
    }

    public void setXmlnsDmndi(String xmlnsDmndi) {
        this.xmlnsDmndi = xmlnsDmndi;
    }

    public String getXmlnsDc() {
        return xmlnsDc;
    }

    public void setXmlnsDc(String xmlnsDc) {
        this.xmlnsDc = xmlnsDc;
    }

    public String getXmlnsModeler() {
        return xmlnsModeler;
    }

    public void setXmlnsModeler(String xmlnsModeler) {
        this.xmlnsModeler = xmlnsModeler;
    }

    public String getXmlnsBiody() {
        return xmlnsBiody;
    }

    public void setXmlnsBiody(String xmlnsBiody) {
        this.xmlnsBiody = xmlnsBiody;
    }

    public String getXmlCamunda() {
        return xmlCamunda;
    }

    public void setXmlCamunda(String xmlCamunda) {
        this.xmlCamunda = xmlCamunda;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getExporter() {
        return exporter;
    }

    public void setExporter(String exporter) {
        this.exporter = exporter;
    }

    public String getExporterVersion() {
        return exporterVersion;
    }

    public void setExporterVersion(String exporterVersion) {
        this.exporterVersion = exporterVersion;
    }

    public String getModelerExecutionPlatform() {
        return modelerExecutionPlatform;
    }

    public void setModelerExecutionPlatform(String modelerExecutionPlatform) {
        this.modelerExecutionPlatform = modelerExecutionPlatform;
    }

    public String getModelerExecutionPlatformVersion() {
        return modelerExecutionPlatformVersion;
    }

    public void setModelerExecutionPlatformVersion(String modelerExecutionPlatformVersion) {
        this.modelerExecutionPlatformVersion = modelerExecutionPlatformVersion;
    }

    @Override
    public String toString() {
        return "Definitions{" +
                "decision=" + decision +
                ", dmndi=" + dmndi +
                ", xmlns='" + xmlns + '\'' +
                ", xmlnsDmndi='" + xmlnsDmndi + '\'' +
                ", xmlnsDc='" + xmlnsDc + '\'' +
                ", xmlnsModeler='" + xmlnsModeler + '\'' +
                ", xmlnsBiody='" + xmlnsBiody + '\'' +
                ", xmlCamunda='" + xmlCamunda + '\'' +
                ", name='" + name + '\'' +
                ", namespace='" + namespace + '\'' +
                ", exporter='" + exporter + '\'' +
                ", exporterVersion='" + exporterVersion + '\'' +
                ", modelerExecutionPlatform='" + modelerExecutionPlatform + '\'' +
                ", modelerExecutionPlatformVersion='" + modelerExecutionPlatformVersion + '\'' +
                '}';
    }
}
