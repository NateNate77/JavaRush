package com.javarush.task.task34.task3404;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;


/*
Рекурсия для мат. выражения
*/
public class Solution {
    public class Wrapper{
        public int count = 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "10-2^(2-1+1)";
        System.out.print(s + " expected output 6 4 actually ");
        solution.recursion(s, 0);
        s = "2^10+2^(5+5)";
        System.out.print(s + " expected output 2048 4 actually ");
        solution.recursion(s, 0);
        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
        System.out.print(s + " expected output 72.96 8 actually ");
        solution.recursion(s, 0);
        s = "0.000025+0.000012";
        System.out.print(s + " expected output 0 1 actually ");
        solution.recursion(s, 0);
        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
        System.out.print(s + " expected output -3 16 actually ");
        solution.recursion(s, 0);
        s = "cos(3 + 19*3)";
        System.out.print(s + " expected output 0.5 3 actually ");
        solution.recursion(s, 0);
        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
        System.out.print(s + " expected output 8302231.36 14 actually ");
        solution.recursion(s, 0);
        s = "(-1 + (-2))";
        System.out.print(s + " expected output -3 3 actually ");
        solution.recursion(s, 0);
        s = "sin(100)-sin(100)";
        System.out.print(s + " expected output 0 3 actually ");
        solution.recursion(s, 0);
        s = "sin(-30)";
        System.out.print(s + " expected output -0.5 2 actually ");
        solution.recursion(s, 0);
        s = "cos(-30)";
        System.out.print(s + " expected output 0.87 2 actually ");
        solution.recursion(s, 0);
        s = "tan(-30)";
        System.out.print(s + " expected output -0.58 2 actually ");
        solution.recursion(s, 0);
        s = "2+8*(9/4-1.5)^(1+1)";
        System.out.print(s + " expected output 6.48 6 actually ");
        solution.recursion(s, 0);
        s = "0.005 ";
        System.out.print(s + " expected output 0.01 0 actually ");
        solution.recursion(s, 0);
        s = "0.0049 ";
        System.out.print(s + " expected output 0 0 actually ");
        solution.recursion(s, 0);
        s = "0+0.304";
        System.out.print(s + " expected output 0.3 1 actually ");
        solution.recursion(s, 0);

    }


    public void recursion(final String expression, int countOperation) {
        String newExpression = expression.replaceAll(" ", "");
        Wrapper count = new Wrapper();
        count.count = countOperation;

        int paranthPos = newExpression.lastIndexOf("(");
        if(paranthPos== -1){
            double finalResult;
            try {
                finalResult = Double.parseDouble(newExpression);
            }
            catch (Exception e){
                finalResult = recursionOperation("+", newExpression, count);
            }

            DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.ENGLISH);

            DecimalFormat dec = new DecimalFormat("#.##", dfs);
            System.out.println(dec.format(finalResult) + " " + count.count);
            return;
        }
        String lastOpenParantesis = newExpression.substring(paranthPos+1);
        String innerParantesis = lastOpenParantesis.substring(0, lastOpenParantesis.indexOf(")"));

        String afterParantesis = lastOpenParantesis.indexOf(")")==lastOpenParantesis.length()-1 ? "" : lastOpenParantesis.substring(lastOpenParantesis.indexOf(")")+1);
        String newExp;
        String resultInParanth;

        if(paranthPos>2){
            String trigFun = newExpression.substring(paranthPos-3, paranthPos);
            if(trigFun.equals("sin")){
                resultInParanth = String.valueOf(sin(recursionOperation("+", innerParantesis, count), count));
                newExp = newExpression.substring(0, paranthPos-3) + resultInParanth + afterParantesis;
            }
            else if(trigFun.equals("cos")){
                resultInParanth = String.valueOf(cos(recursionOperation("+", innerParantesis, count), count));
                newExp = newExpression.substring(0, paranthPos-3) + resultInParanth + afterParantesis;
            }
            else if(trigFun.equals("tan")){
                resultInParanth = String.valueOf(tan(recursionOperation("+", innerParantesis, count), count));
                newExp = newExpression.substring(0, paranthPos-3) + resultInParanth + afterParantesis;
            }
            else {
                resultInParanth = String.valueOf(recursionOperation("+", innerParantesis, count));
                newExp = newExpression.substring(0, paranthPos) + resultInParanth + afterParantesis;
            }
        }
        else {
            resultInParanth = String.valueOf(recursionOperation("+", innerParantesis, count));
            newExp = newExpression.substring(0, paranthPos) + resultInParanth + afterParantesis;
        }

        recursion(newExp, count.count);


        //implement
    }

    public Double recursionOperation (String a, String expr, Wrapper count){
        expr = expr.replaceAll("\\+-", "-");
        expr = expr.replaceAll("--", "\\+");
        String operation = String.format("\\%s", a);
        String[] result = expr.split(operation);
        String newA;

        switch (a){
            case "+":
                newA = "-";
                break;
            case "-":
                newA = "*";
                break;
            case "*":
                newA = "/";
                break;
            case "/":
                newA = "^";
                break;
            case "^":
                newA = "#";
                break;


            default:
                double num = Double.parseDouble(expr);
                return num;

        }
        if(result.length==1){
            return recursionOperation(newA, expr, count);
        }
        else {
            for(int i = 0; i< result.length; i++){
                if((result[i].endsWith("^") || result[i].endsWith("*") || result[i].endsWith("/")) && a.equals("-")){
                    if (i > 0 && result[i-1].equals("")){
                        count.count++;
                    }
                    return recursionOperation(newA, expr, count);
                }
            }
            ArrayList<Double> numbers = new ArrayList<>();
            for (String el : result){
                if(el.equals("")){
                    el="0";
                }
                double number = recursionOperation(newA, el, count);
                numbers.add(number);
            }
            switch (a) {
                case "+":
                    return sum(numbers, count);
                case "-":
                    return subtraction(numbers, count);
                case "*":
                    return multiplication(numbers, count);
                case "/":
                    return segmentation(numbers, count);
                case "^":
                    return exponentiation(numbers, count);
                default:
                    return null;
            }
        }

    }

    public double multiplication(ArrayList<Double> array, Wrapper count) {
        count.count--;
        double result = 1;
        for (int i = 0; i < array.size(); i++) {
            result *= array.get(i);
            count.count++;

        }

        return BigDecimal.valueOf(result)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

    }

    public double sum(ArrayList<Double> array, Wrapper count){
        count.count--;
        double result = 0;
        for (int i = 0; i < array.size(); i++){
            result +=array.get(i);
            count.count++;

        }
        return  BigDecimal.valueOf(result)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public double subtraction(ArrayList<Double> array, Wrapper count){
        double result = array.get(0) - array.get(1);
        count.count++;
        if(array.size()>2){
            for (int i = 2; i<array.size(); i++){
                result-=array.get(i);
                count.count++;
            }
        }
        return  BigDecimal.valueOf(result)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public double segmentation(ArrayList<Double> array, Wrapper count){
        double result = array.get(0)/array.get(1);
        count.count++;
        if(array.size()>1){
            for (int i = 2; i<array.size(); i++){
                result/=array.get(i);
                count.count++;
            }
        }
        return  BigDecimal.valueOf(result)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

    }

    public double exponentiation(ArrayList<Double> array, Wrapper count){
        double result = Math.pow(array.get(array.size()-2), array.get(array.size()-1));
        count.count++;
        if(array.size()>2){
            for(int i = array.size()-3; i>=0; i--){
                result = Math.pow(array.get(i-1), result);
                count.count++;
            }
        }
        return  BigDecimal.valueOf(result)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

    }

    public double sin(double a, Wrapper count){
        double angleInRadian = Math.toRadians(a);
        double sin = Math.sin(angleInRadian);
        count.count++;
        return  BigDecimal.valueOf(sin)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

    }

    public double cos(double a, Wrapper count){
        double angleInRadian = Math.toRadians(a);
        double cos = Math.cos(angleInRadian);
        count.count++;
        return  BigDecimal.valueOf(cos)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

    }

    public double tan(double a, Wrapper count){
        double angleInRadian = Math.toRadians(a);
        double tan = Math.tan(angleInRadian);
        count.count++;
        return  BigDecimal.valueOf(tan)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public Solution() {
        //don't delete
    }
}