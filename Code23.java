package chap01;

import java.io.*;
import java.util.* ;

public class Code23 {
	
	static String [] words = new String [100000];
	static int [] count = new int[100000];
	static int n;
	// ���� ���� ��ü������ ������ ����� �ʾҴٴ� �����Ͽ� ���� static�� �ٿ��� ���������� ����? �������� �³� ��
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.print("$");
			String command = kb.next();// �޶� ǥ�� ���� �Է��� �޾�
			if(command.equals("read")) {
				String fileName = kb.next();
				makeIndex(fileName);
				//���� �Է��� Ŀ�ǵ尡 read�� ���� �Է��� fileName�� ������ �迭�� �־��ִ� �޼ҵ� �� �������� !
			}
			else if(command.equals("find")) {
				String str = kb.next();
				int index = findWord(str);
				//find ��� ��ɾ �Է¹����� Ư�� �ܾ ��� �������� �迭�� ����
				if(index != -1) {
					System.out.println("The word "+ words[index]+" appears "+count[index]+" times.");
					
				}else {
					System.out.println("The word "+str+" doesn't appear.");
				}
				
					
			}
			else if (command.equals("saveas")) {
				String fileName = kb.next();
				saveAs(fileName);
			}
			else if(command.equals("exit")) {
				break;
			}
		}
		kb.close();
	}
	static void saveAs(String fileName) {
		PrintWriter outFile;
		try {
			outFile = new PrintWriter(new FileWriter(fileName));//fileWriter ��ü�� �����Ѱ� fileName�̶�� �Ű������� ���� �̸����� ���� 
			for (int i=0; i<n; i++) {
				outFile.println(words[i]+" "+count[i]);
			}
			
			
			outFile.close();
		} catch (IOException e) {
			
			System.out.println("Save failed");
			return;
		} 
		
	}
	private static void makeIndex(String fileName) {
		//�굵 static �ΰ� ���� Ŭ������ ��ü..... static�� ���� �������ʾ�
		//�о���°� 
		Scanner inFile;
		try {
			inFile = new Scanner( new File(fileName));//���� ���� �߿乮��
			//�� �� ����� ������ ����°� �ƴ϶� �ִ� ������ �о���� �ű��� �״ϱ� �׳� ��ĳ�ʷ� �ִ� ������ �о���°ſ���!!
			while(inFile.hasNext()) {
				String str = inFile.next();
				//���⼭ �Է¹��� str�� ù������ �Է¹����ǰ� �ι�°�� �Է¹����ǰ� �˾Ƴ����ϴµ� �׾����� �ٸ� �޼ҵ�� �Ѱ� ~!
				
				
				String trimmed = trimming(str);
				if (trimmed != null) {
					String t = trimmed.toLowerCase();
					addWord(t);
				}
				//addWord(trimmed);//str�� ��Ͽ� ������ ī��Ʈ ���� ó���̸� ��Ͽ��߰� �޼ҵ�
				
				
			}
			inFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("���Ͼ���");
		}
		
			
			
		
	
	
	}
	
	static String trimming(String str) {
		
		int i = 0, j = str.length()-1;
		while(i < str.length() && !Character.isLetter( str.charAt(i) ) )// while i ��°�� ���ĺ��� �ƴϸ�
			i++;
		while(j >= 0 && !Character.isLetter( str.charAt(j) ) )// while i ��°�� ���ĺ��� �ƴϸ�
			j--;
		
		if ( i > j )
			return null;
		
	
		return str.substring(i,j+1);
		
	}
	static void addWord(String str) {
		
		int index = findWord(str);
		
		if (index != -1) {//�������� �󵵸� 1�� ��������
			count[index]++;
		}
		else {//not found ������ �ǵڿ� �״µ� ���� ������ �ؼ� �־���� �� �ڸ��� ordered list �� insert �Ѵ�!
			int i= n-1;
			while(i>=0 && words[i].compareTo(str)>0) {
				words[i+1]=words[i];
				count[i+1]=count[i];
				i--;
			}
			
			
			words[i+1] = str;
			count[i+1]= 1;
			n++;
		}
	}
	static int findWord(String str) {
		//�迭 words�� str�� �ִ��� ������!
		for (int i=0; i<n; i++) {
			if (words[i].equals(str)) {
				return i;
			}
		}	
		return -1;
		
		
	}

}
