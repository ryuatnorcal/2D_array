import java.util.Stack;

/**
 * Given a 2-dimensional array of characters and a
 * dictionary in which a word can be searched in O(1) time.
 * Need to print all the words from array which are present
 * in dictionary. Word can be formed in any direction but
 * has to end at any edge of array.
 * (Need not worry much about the dictionary)
 */
public class d {
	
	private String[] libs = {"hair", "after","tedd","hate","awe","eat","tea"};
	private char[][] matrix = new char[][]{
				{'a', 'f', 'h', 'u', 'n'},
		        {'e', 't', 'a', 'i', 'r'},
		        {'a', 'e', 'g', 'g', 'o'},
		        {'t', 'r', 'm', 'l', 'p'}
	        };
	
    private int x = 4; 
    private int y = 5;
    private int libsLen;
    private boolean[][] visited;
    private Stack<Integer> stackX;
    private Stack<Integer> stackY;
	
	public d(){
		visited = new boolean[x][y];
		stackX = new Stack<Integer>();
		stackY = new Stack<Integer>();
		libsLen = libs.length;		
	}
	
	private void resetVisited(){
		for(int i=0; i < x; i++){
			for(int k=0; k < y; k++){
				visited[i][k] = false; 
			}
		}
	}
	public void print(){
		resetVisited();		
		for(int i = 0; i < libsLen; i++){
			for(int j=0; j < x; j++){
				for(int k=0; k < y; k++){					
					searchAndPrint(j,k,libs[i]);
				}
			}
			resetVisited();
		}
	}
	
	public void searchAndPrint(int startX, int startY, String target ){
		int index = 0;
		char charTarget = target.charAt(index);
		Integer v = (Integer) startX;
		Integer w = (Integer) startY;		
		String newStr="";
		stackX.push(v);
		stackY.push(w);
		
		while(!stackX.isEmpty() && !stackY.isEmpty()){
			v = stackX.pop();
			w = stackY.pop();
			if(!visited[v][w]){
				visited[v][w] = true;
			
				if(matrix[v][w] == charTarget){
					newStr = newStr + matrix[v][w];		
					
					if(index < target.length()-1){
						index++;					
						charTarget = target.charAt(index);
					}
					if(target.equals(newStr)){
						System.out.println(newStr + " found! ");						
					}
				
					if(v-1 > -1){
						stackX.push(v-1);
						stackY.push(w);
					}
					if(w+1 < y){
						stackX.push(v);
						stackY.push(w+1);
					}
					if(v+1 < x){
						stackX.push(v+1);
						stackY.push(w);
					}
					if(w-1 > -1){
						stackX.push(v);
						stackY.push(w-1);
					}
				}				
			}
		}
	}
	
}
