package util;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;
import java.util.Vector;

public class BddObj {
    public static String majStart(String m){
        m=m.replaceFirst(String.valueOf(m.charAt(0)), String.valueOf(m.charAt(0)).toUpperCase());
        return m;
    }
    Class parser(String type) throws Exception{
        if(type.equals("Integer")||type.equals("int"))
            return Integer.class;
        return null;
    }
    String parseMethod(String type) throws Exception{
        if(type.equals("Integer")||type.equals("int"))
            return "parseInt";
        return null;
    }
    public Vector selectAll() throws Exception{
        File file=new File("./src/datas/"+getClass().getSimpleName()+".txt");
        Scanner scan=new Scanner(file);
        try{
            Vector liste=new Vector();
            Field[] fields= getClass().getDeclaredFields();
            while(scan.hasNextLine()){
                Object object=getClass().getConstructor().newInstance();
                String[] columns=scan.nextLine().split("::");
                for(int i=0; i<fields.length; i++){
                    Class type=fields[i].getType();
                    if(type.getSimpleName().equals("String"))
                        getClass().getMethod("set"+majStart(fields[i].getName()), String.class).invoke(object, columns[i]);
                    else{
                        Class parser=parser(type.getSimpleName());
                        String methodParse=parseMethod(type.getSimpleName());
                        getClass().getMethod("set"+majStart(fields[i].getName()), type).invoke(object, parser.getMethod(methodParse, String.class).invoke(parser, columns[i]));
                    }
                }
                liste.add(object);
            }
            return liste;
        }finally {
            scan.close();
        }
    }
    public Object getElementByID(Object[] liste) throws Exception{
        Field[] fields= getClass().getDeclaredFields();
        for(int i=0; i<liste.length; i++){
            Object saValeur=getClass().getMethod("get"+majStart(fields[0].getName())).invoke(liste[i]);
            Object maValeur=getClass().getMethod("get"+majStart(fields[0].getName())).invoke(this);
            if(saValeur.equals(maValeur))
                return liste[i];
        }
        return liste[0];
    }
}
