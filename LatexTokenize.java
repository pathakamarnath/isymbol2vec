import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
public class LatexTokenize {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		final String regex = "(\\b\\w*[\\.]?\\w+\\b|[\\(\\)\\+\\=\\^\\{\\}\\*\\#\\&\\%\\-\\;\\:\\...\\∘\\'\\,\\-\\≤\\≥\\|\\/])";
		
		PrintWriter pw=new PrintWriter("/media/workstation/New Volume/Symbol2Vec/IR/other ir data/LatexFormulaTokenizedNew.txt");
		BufferedReader br=new BufferedReader(new FileReader(new File("/media/workstation/New Volume/Symbol2Vec/IR/other ir data/LatexFormulaTokenized.txt")));
		String line= " ";
		int count=0;
		int flag=0;
		while((line=br.readLine())!=null)
		{
			if(line.trim().length()==0)
				pw.println("unk");
			else
				pw.println(line);
		}
				
		pw.close();
	}
}


