import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
public class MathTokenize {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		final String regex = "(\\b\\w*[\\.]?\\w+\\b|[\\(\\)\\+\\=\\^\\{\\}\\*\\#\\&\\%\\-\\;\\:\\...\\∘\\'\\,\\-\\≤\\≥\\|\\/])";
		
		PrintWriter pw=new PrintWriter("/media/workstation/New Volume/Symbol2Vec/IR/other ir data/LatexFormulaTokenized.txt");
		BufferedReader br=new BufferedReader(new FileReader(new File("/media/workstation/New Volume/Symbol2Vec/IR/other ir data/LatexFormula.txt")));
		String line= " ";
		int count=0;
		while((line=br.readLine())!=null)
		{
			System.out.println("Processing Formula: "+(++count));
			String[] ar=line.split("\t");		
			final Pattern pattern = Pattern.compile(regex);
			final Matcher matcher = pattern.matcher(ar[0]);
			while (matcher.find()) {				
				for (int i = 1; i <= matcher.groupCount(); i++) 
				{
					pw.print(" "+matcher.group(i));
					
				}				
						
		    }
			pw.print("\t");
			final Pattern pattern2 = Pattern.compile(regex);
			final Matcher matcher2 = pattern2.matcher(ar[1]);
			while (matcher2.find()) {				
				for (int i = 1; i <= matcher2.groupCount(); i++) 	
				{
					pw.print(matcher2.group(i)+" ");
					
				}
		    }
			pw.print("\t"+ar[2]);
			pw.println();
		}				
		
		pw.close();

	}

}
