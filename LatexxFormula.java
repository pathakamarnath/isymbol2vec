import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LatexxFormula {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PrintWriter pw=new PrintWriter("/media/workstation/New Volume/Symbol2Vec/IR/other ir data/LatexFormula.txt");
		PrintWriter pw2=new PrintWriter("/media/workstation/New Volume/Symbol2Vec/IR/other ir data/Doc.txt");
		PrintWriter pw3 = new PrintWriter("/media/workstation/New Volume/Symbol2Vec/IR/other ir data/FormDoc.txt");
		PrintWriter pw4 = new PrintWriter("/media/workstation/New Volume/Symbol2Vec/IR/other ir data/formcount2.txt");
		File folder = new File("/media/workstation/New Volume/Symbol2Vec/IR/WikiDocs");
		File[] listOfFiles = folder.listFiles();
		int doccount=0;
		int formulacount=0;
		for (File file : listOfFiles) {
			System.out.println("Processing: "+(++doccount));
			String line=" ",content=" ",latexformula=" ";
			BufferedReader br=new BufferedReader(new FileReader(file));
			while((line=br.readLine())!=null)
			{
				content+=line;
			}
			//System.out.println(content);
			//String open1 = "(?<=\\ alttext=\")";	
			String open1 = "(?<=\\ <annotation encoding=\"application/x-tex\">)";	
			String inside1 = ".*?";
			String close1 = "(?=\\ </annotation>)";	
			String regex1 = open1 + inside1 + close1;
			Matcher matcher1 = Pattern.compile(regex1, Pattern.DOTALL).matcher(content);	
			while (matcher1.find()) {
				formulacount++;
				latexformula=matcher1.group().trim();
				//System.out.println(latexformula);
				pw.println(latexformula);
				pw2.println(file.getName());
				pw3.println(latexformula+"\t"+file.getName());				
				}
				pw4.println(file.getName()+"\t"+formulacount);
				formulacount=0;
			}
		System.out.print("Total Formulae: "+formulacount);
		pw.close();
		pw2.close();
		pw3.close();
		pw4.close();

}
}