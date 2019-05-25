package chap01;

import java.io.*;
import java.util.* ;

public class Code22 {
	
	static String [] words = new String [100000];
	static int [] count = new int[100000];
	static int n;
	// 아직 내가 객체지향적 개념을 배우지 않았다는 가정하에 전부 static을 붙여서 전역변수로 지정? 전역변수 맞나 흠
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.print("$");
			String command = kb.next();// 달라 표시 띄우고 입력을 받아
			if(command.equals("read")) {
				String fileName = kb.next();
				makeIndex(fileName);
				//내가 입력한 커맨드가 read면 내가 입력한 fileName의 파일을 배열에 넣어주는 메소드 를 구현하자 !
			}
			else if(command.equals("find")) {
				String str = kb.next();
				int index = findWord(str);
				//find 라는 명령어를 입력받으면 특정 단어가 몇번 나오는지 배열에 저장
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
			outFile = new PrintWriter(new FileWriter(fileName));
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
		//얘도 static 인건 아직 클래스와 객체..... static은 보통 쓰이지않아
		Scanner inFile;
		try {
			inFile = new Scanner( new File(fileName));
			while(inFile.hasNext()) {
				String str = inFile.next();
				//여기서 입력받은 str이 첫번쨰로 입력받은건가 두번째로 입력받은건가 알아내야하는데 그업무도 다른 메소드로 넘겨 ~!
				
				addWord(str);//str이 목록에 있으면 카운트 증가 처음이면 목록에추가 메소드
				
				
			}
			inFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일없어");
		}
		
			
			
		
	
	
	}
	
	static void addWord(String str) {
		int index = findWord(str);
		if (index != -1) {//found
			count[index]++;
		}
		else {//not found
			words[n] = str;
			count[n]= 1;
			n++;
		}
	}
	static int findWord(String str) {
		//배열 words에 str이 있는지 없는지!
		for (int i=0; i<n; i++) {
			if (words[i].equals(str)) {
				return i;
			}
		}	
		return -1;
		
		
	}

}
