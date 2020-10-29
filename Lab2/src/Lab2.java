//Variant1

public class Lab2 {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder(args[0]);
        System.out.println(str);
        boolean flag = false;
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                int tempI = i;
                int count = 1;
                i++;

                while(str.charAt(i) != ')'){
                    if(str.charAt(i) =='(')
                        break;
                    count++;
                    i++;
                }
                if(str.charAt(i) == '(') {
                    count = 0;
                    tempI = i;
                    i--;
                    continue;
                }
                if(str.charAt(i) == ')'){
                    while(count>0){
                        str.deleteCharAt(i--);
                        count--;
                    }
                    str.deleteCharAt(tempI);
                    i = tempI;
                    i--;
                }
            }
        }
        System.out.println(str);
    }
}
