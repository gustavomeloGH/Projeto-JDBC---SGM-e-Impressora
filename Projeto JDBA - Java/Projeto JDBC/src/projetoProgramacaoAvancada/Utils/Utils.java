package projetoProgramacaoAvancada.Utils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JOptionPane;
import projetoProgramacaoAvancada.Entity.EnumEntity;
import projetoProgramacaoAvancada.Entity.Funcionario;
import projetoProgramacaoAvancada.Entity.RemovedEmployee;
import projetoProgramacaoAvancada.Entity.ReportsPrinter;

public class Utils {

    public static String retirarCaracterEspecial(String string) {
        string = string.replaceAll("\\.", "");
        string = string.replaceAll("-", "");
        string = string.replaceAll("\\(", "");
        string = string.replaceAll("\\)", "");
        string = string.replaceAll("\\/", "");
        string = string.trim();
        return string;
    }

    public static String reformatarCpf(String cpf) {
        String cpfNovo = "";
        for (int i = 0; i < cpf.length(); i++) {
            cpfNovo += cpf.charAt(i);
            if (i == 2 || i == 5) {
                cpfNovo += ".";
            }
            if (i == 8) {
                cpfNovo += "-";
            }
        }
        return cpfNovo;
    }

    public static String reformatarData(String data) {
        data = retirarCaracterEspecial(data);
        String novaData = data.substring(6, 8) + data.substring(4, 6) + data.substring(0, 4);
        return novaData;
    }

    public static String formatDate(String date) {
        return date.replaceAll("/", "-");
    }

    private static void createPdf(String dest, String title, int tableSize, String[] columnsName, String[][] object) throws IOException, DocumentException {

        Document document = new Document(PageSize.A2, 0, 0, 0, 0) {};
        String date = new SimpleDateFormat("dd-MM-yyyy (Hmmss)").format(Calendar.getInstance().getTime());
        dest = dest + date + ".pdf";
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(tableSize);

        table.setWidthPercentage(98);
        table.setSpacingBefore(0.0f);
        table.setSpacingAfter(0.0f);

        // first row
        PdfPCell cell = new PdfPCell(new Phrase(title));
        cell.setColspan(20);
        cell.setBorder(Rectangle.BOTTOM);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(40.0f);
        table.addCell(cell);

        for (String columnName : columnsName) {
            cell = new PdfPCell(new Phrase(columnName));
            cell.setBackgroundColor(new BaseColor(222, 222, 222));
            table.addCell(cell);
        }

        for (String[] objectRows : object) {
            if (objectRows != null) {
                for (String objectColumns : objectRows) {
                    table.addCell(objectColumns);
                }
            }
        }
        document.add(table);
        try {

            Utils.openThisPDF(writer, dest);
            document.close();

        } catch (Exception ex) {
            document.close();
            JOptionPane.showMessageDialog(null, Msg.DAO_ERROR + " Não foi possível abri o relatório!");
        }
    }
    
    
    private static void openThisPDF(PdfWriter writer, String dest) throws Exception {
        File openFile = new File(dest);
        Desktop.getDesktop().open(openFile);
    }

    

    public static void reportsEmployeeGenerator(ArrayList arrayList, String dest, String title, int type) throws Exception {

        int size = arrayList.size();
        String[][] arrayMatrix = new String[size][size];
        String[] columnsName = null;
        if (!arrayList.isEmpty()) {
            for (int i = 0; i < size; i++) {

                switch (type) {
                    case EnumEntity.EMPLOYEE:
                        arrayMatrix[i] = ((Funcionario) arrayList.get(i)).toStringArrayFull();
                        columnsName = Utils.toStringFieldsEmployee();
                        break;
                    case EnumEntity.REMOVEDEMPLOYEE:
                        arrayMatrix[i] = ((RemovedEmployee) arrayList.get(i)).toStringArray();
                        columnsName = Utils.toStringFieldsRemovedEmployee();
                        break;
                    case EnumEntity.REPORTSPRINTER:
                        arrayMatrix[i] = ((ReportsPrinter) arrayList.get(i)).toStringArray();
                        columnsName = Utils.toStringFieldsPrinter();
                        break;
                }
            }
        }
        int sizeColumns = columnsName.length;
        Utils.createPdf(dest, title, sizeColumns, columnsName, arrayMatrix);
    }

    public static String formatSqlDateString(String date) {
        date = date.replaceAll("-", "/");
        date = date.substring(8, 10) + date.substring(4, 8) + date.substring(0, 4);
        return date;
    }

    public static void reportsPrinterGenerator() throws Exception {
        String[] columnsName = Utils.toStringFieldsPrinter();
        int size = columnsName.length;
        String dest = Constt.DIRECTORY_PATH_RELATORIO_PRINTER;
        String title = Msg.TITLE_REPORTS_PRINT;
    }

    public static String[] toStringFieldsEmployee() {
        return new String[]{"Matrícula", "Nome", "Sexo", "Data Nascimento", "Cpf", "Telefone", "Cargo", "Departamento", "Rua", "Número", "Cidade", "Bairro", "UF", "Complemento"};
    }

    public static String[] toStringFieldsRemovedEmployee() {
        return new String[]{"Matrícula", "Nome", "Sexo", "Data Nascimento", "Cpf", "Telefone", "Cargo", "Departamento", "Matrícula Gerente", "Nome Gerente", "Data Exclusão", "Motivo da Exclusão"};
    }

    public static String[] toStringFieldsPrinter() {
        return new String[]{"Data Impressão", "Matrícula Funcionário", "Nome Funcionário", "Cpf Funcionário", "Marca Impressora", "Modelo Impressora", "Tamanho do Arquivo", "Prioridade", "Tipo Documento"};
    }

    public static int getPriorityByCargo(int cargo) {
        int priority = 0;
        switch (cargo) {
            case 1:
                priority = 3;
                break;
            case 2:
                priority = 2;
                break;
            case 3:
                priority = 1;
                break;
            case 4:
                priority = 5;
                break;
            case 5:
                priority = 4;
                break;
            default:
                priority = cargo;
                break;
        }
        return priority;
    }

    public static int getIdImpressora() {
        Random r = new Random();
        return r.nextInt((2 - 1) + 1) + 1;
    }

}
