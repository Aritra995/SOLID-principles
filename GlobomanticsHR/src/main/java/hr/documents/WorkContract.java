package hr.documents;

public class WorkContract implements ExportableText,ExportableJson,ExportablePdf{
    private String content;
    public WorkContract(String content){
        this.content = content;
    }
    @Override
    public String toTxt() {
        return this.content;
    }

    @Override
    public String toJson() {
        return "{'Content':'"+this.content+"'}";
    }

    @Override
    public byte[] toPdf() {
        return content.getBytes();
    }
}
