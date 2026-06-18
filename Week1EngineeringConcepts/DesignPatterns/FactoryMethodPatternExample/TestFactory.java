public class TestFactory {

    public static void main(String[] args) {

        DocumentFactory factory = new ExcelFactory();

        Document doc = factory.createDocument();

        doc.open();
    }
}