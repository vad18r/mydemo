package mypackage;


import java.util.*;

public class calc {
    static String toRome(Integer i) throws Exception {
        String str="";
        Map<Integer, String> rome = new HashMap<Integer, String>();
        rome.put(0,"");
        rome.put(1,"I");
        rome.put(2,"II");
        rome.put(3,"III");
        rome.put(4,"IV");
        rome.put(5,"V");
        rome.put(6,"VI");
        rome.put(7,"VII");
        rome.put(8,"VIII");
        rome.put(9,"IX");
        rome.put(10,"X");
        rome.put(20,"XX");
        rome.put(30,"XXX");
        rome.put(40,"XL");
        rome.put(50,"L");
        rome.put(60,"LX");
        rome.put(70,"LXX");
        rome.put(80,"LXXX");
        rome.put(90,"XC");
        rome.put(100,"C");
        int c2=(i%100)/10, c1=i%10;

        if (i<=0)
        {
            throw new Exception("throws Exeption");
        }
        else
        {
            if (i == 100){
                return rome.get(i);
            }
            if ((i<100)&(i>9))
            {
                return rome.get((c2*10))+rome.get(c1);
            }
            if (i<10)
            {
                return rome.get(i);
            }
        }

        return str;
    }

    public static String calc(String a) throws Exception  {
        String[] romeAlph = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

        String arab = "^([1-9]|10)([+]|[*]|[/]|[-])([1-9]|10)$";
        boolean isArab = a.matches(arab);
        String rome = "^(I|II|III|IV|V|VI|VII|VIII|IX|X)([+]|[*]|[/]|[-])(I|II|III|IV|V|VI|VII|VIII|IX|X)$";
        boolean isRome = a.matches(rome);
        int firstNum=0,secondNum=0,result=0;
        if (isRome|isArab)
        {
            String[] s = a.split("[+]|[-]|[*]|[/]");
            if (isArab) {
                firstNum = Integer.parseInt(s[0]);
                secondNum = Integer.parseInt(s[1]);
            }
            else
            {
                firstNum=1;secondNum=1;
                for (String s1: romeAlph)
                {
                    if (s[0].equals(s1))
                    {
                        break;
                    }
                    else
                    {
                        firstNum++;
                    }
                }
                for (String s1: romeAlph)
                {
                    if (s[1].equals(s1))
                    {
                        break;
                    }
                    else
                    {
                        secondNum++;
                    }
                }

            }
            if (a.contains("+")){
                result = firstNum+secondNum;
            }
            if (a.contains("-")){
                result = firstNum-secondNum;
            }
            if (a.contains("*")){
                result = firstNum*secondNum;
            }
            if (a.contains("/")){
                result = firstNum/secondNum;
            }

            if (isArab){
                System.out.println(result);
            }
            else
            {
                System.out.println(toRome(result));
            }
        }
        else {
                throw new Exception("throws Exeption");
        }
        return "";
    }

    public static void main(String[] args)
    {
        try
        {
            calc("X*III");
            calc("10/3");
            calc("9/9");
            calc("8/5");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
