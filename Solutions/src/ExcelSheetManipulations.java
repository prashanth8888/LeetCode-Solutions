package SampleTest;

/**
 * @author ps
 *
 */
public class ExcelSheetManipulations {
	
	
	/**
	 * @param columnMapping
	 * @return
	 */
	public long numbertoColumnLabel(String columnMapping) {
		long result = 0;
		columnMapping = columnMapping.trim().toUpperCase();
		
		for(int i = 0; i < columnMapping.length(); i++) {
			int charValue = ((columnMapping.charAt(i) - 'A') % 26) + 1;
			result = (result * 26) + charValue;
		}
		
		return result;
	}
	
	public String mapColumnLabel(long columnNumber) {
		
		if(columnNumber == 0) return "";
		
		return mapColumnLabel(columnNumber / 26) + (char) ((columnNumber % 26) - 1 + 'A');
		
	}
	/**
	 * @param args
	 */ 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelSheetManipulations obj = new ExcelSheetManipulations();
		System.out.println(obj.mapColumnLabel(92));
		System.out.println(obj.numbertoColumnLabel("CN"));
	}

}
