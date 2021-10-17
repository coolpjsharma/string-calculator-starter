package calculator;

class StringCalculator {

    public int add(String input) {
    	if(input.isEmpty())
        return 0;
    	else if(input.contains(",")) {
    		String[] numbers = number_extractor(input);
    		int result=0;
    		for(int i=0; i<numbers.length; i++ ) {
    			result +=Integer.parseInt(numbers[i]);
    		}
    		return result;
     	}
    	else
    		return Integer.parseInt(input);
    }
    
    private static String[] number_extractor(String input) {
    	String[] numbers = input.split(",|\n");
    	return numbers;
    }

}