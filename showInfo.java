import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class showInfo {
     
     String[] lineList=new String[1000];
     classInfo[] classList=new classInfo[1000];
     Variable[] varList=new Variable[1000];
     Method[] methodList=new Method[1000];
     String tempType;
     int countClass=0;
     int countVar=0;
     int countMethod=0;
     public int rank;   
     String path;
     String path1;
    public showInfo(String path)
    {
        this.path=path;
    }
    public showInfo(String path,String path1)
    {
        this.path=path;
        this.path1=path1;
    }
    
    public classInfo[] getCl()
    {
        return classList;
    }
    public void addVar(Variable var)
    {
        varList[countVar]=var;
        countVar++;
    }
    public void addClass(classInfo cls)
    {   
        classList[countClass]=cls;
        
        countClass++;
        
    }
    public void addMethod(Method m)
    {   
       methodList[countMethod]=m;
        
        countMethod++;
        
    }
    
   
                
    
    
    
    public void readFile() throws IOException {
        
        int i=0;
        

        
        
        
        try {

            //File f = new File("F:/File/Cylinder.java");
            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            

            while ((readLine = b.readLine()) != null) {
                
                lineList[i++]=readLine.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
    public  void getClassInfo()
    {
       String[] tempList=new String[100];
       tempList=lineList;
       //Xoa cmt block
       for(int i=0;i<tempList.length;i++)
       {
           if(tempList[i]==null)
               break;
           int j=i;
           if(tempList[i].contains("/*"))
           {
              
               while(!tempList[j].contains("*/"))
               {
                   tempList[j]="";
                   j++;
               }
               tempList[j]="";
           }
       }
       //Xoa cmt Line
       for(int i=0;i<tempList.length;i++)
       {
           if(tempList[i]==null) break;
           if(tempList[i].contains("//"))
           {
               String[] temp2=tempList[i].split("//");
               tempList[i]=temp2[0];
           }
       }
        //Get ten class
        for(int i=0;i<tempList.length;i++)
        {
            
            if(tempList[i]!=null)
            {
               
                
                if(tempList[i].contains("class")||tempList[i].contains("interface")&&!tempList[i].contains("//"))
                {
                    /*
                    if(tempList[i].contains("extends"))
                    {
                         String[] p = tempList[i].split(" ");
                         for(int j=0;i<p.length;j++)
                         {
                             if(p[j].equals("extends"))
                             {
                                 addClass(new classInfo(p[j-1],p[j+1]));
                             }
                         }
                    
                    }
                    else
                    {
                        String[] p = tempList[i].split(" ");
                        for(int j=0;i<p.length;j++)
                         {
                             if(p[j].equals("class"))
                             {
                                 addClass(new classInfo(p[j+1]));
                             }
                         }
                    
                    }
                    */
                    
                    String[] parts = tempList[i].split("\\s+");
                    for(int j=0;j<parts.length;j++)
                    {
                        if(parts[j].equals("class")||parts[j].equals("interface"))
                        {
                            
                            
                             try {
                            if(tempList[i].contains("extends"))
                            {
                            addClass(new classInfo(parts[j+1].replaceAll("\\{", ""),parts[j+3].replaceAll("\\{"," ").trim(),1));
                            }
                            else
                            {
                            addClass(new classInfo(parts[j+1].replaceAll("\\{", ""),parts[j+3].replaceAll("\\{"," ").trim(),2));
                            }
                            break;
                         }
                     catch(ArrayIndexOutOfBoundsException ignored) {
                            addClass(new classInfo(parts[j+1].replaceAll("\\{", "")));
            }
                        }

                    }
                
                }
            }
        }
        
       
       
        //Lay ten bien  
        for(int i=0;i<tempList.length;i++)
        {
             if(tempList[i]!=null && tempList[i].contains("(")&&!tempList[i].contains(".")&&!tempList[i].contains("+")&&!tempList[i].contains("-")&&!tempList[i].contains("*")&&!tempList[i].contains("/")&&tempList[i].contains(")")&&!tempList[i].contains("=")&&!tempList[i].contains(">")&&!tempList[i].contains("if")&&!tempList[i].contains("for")&&!tempList[i].contains("catch")&&!tempList[i].contains("new"))
                 break;
            if(tempList[i]!=null)
            {
                 className cl=new className(path1);
                 String[] list=cl.name();
                 
                for(int k=0;k<list.length;k++)
                {
                    if(list[k]==null)
                        break;
                    if(tempList[i].contains(list[k])&&tempList[i].contains("new"))
                    {
                        tempList[i]=tempList[i].replaceAll("=", " ");
                        
                        String[] tarr=tempList[i].split(" ");
                        for(int a=0;a<tarr.length;a++)
                        {
                            if(tarr[a].equals("new"))
                            {
                                if(tempList[i].contains("["))
                                {
                                    if(!tarr[a-1].trim().equals(""))
                                    {
                                    addVar(new Variable(tarr[a-1]," "+"<a>"+tarr[a+1].replaceAll(";","")));
                                    }
                                    
                                }
                                else
                                {
                                    if(!tarr[a-1].trim().equals(""))
                                    {
                                    addVar(new Variable(tarr[a-1]," "+"<a>"+list[k].replaceAll(";","")));
                                    }
                                    
                                }
                            }
                            
                        }
                        
                    }
                    
                }
                 
                
                
                
                
                if(tempList[i].contains("int")||tempList[i].contains("float")||tempList[i].contains("double")||tempList[i].contains("String")||tempList[i].contains("boolean"))
                {
                    if(!tempList[i].contains("(")&&!tempList[i].contains("{")&&!tempList[i].contains("(")&&!tempList[i].contains("interface"))
                    {
                    tempList[i]=tempList[i].replaceAll(";","");
                    tempList[i]=tempList[i].replaceAll("final","");
                    tempList[i]=tempList[i].replace("public","");
                    tempList[i]=tempList[i].replace("protected","");
                    tempList[i]=tempList[i].replace("private","");
                    //Xoa kieu static
                    tempList[i]=tempList[i].replace("static","");
                    tempList[i]=tempList[i].trim();
                    
                            if(!tempList[i].contains("="))
                            {
                                String[] getVar=tempList[i].split(" ");
                                String type=getVar[0];
                                getVar[0]="";
                                String name=String.join("",getVar);
                                if(name.contains(","))
                                {
                                    String[] names=name.split(",");
                                    for(int k=0;k<names.length;k++)
                                    {
                                        addVar(new Variable(names[k], type));
                                    }
                                    
                                }
                                
                            }
                            else
                            {
                                    
                                    String[] getValue=tempList[i].split("=");
                                    
                                    String[] getVar=getValue[0].trim().split(" ");
                                    
                                    
                                    
                                    if(getVar[0].equals("String[]"))
                                        addVar(new Variable(getVar[1],getValue[1].trim().replaceAll("new","")));
                                    else
                                    {
                                    addVar(new Variable(getVar[1], getVar[0],getValue[1].trim().replaceAll("new","")));
                                    }
                                    
                            }
                    }
                }
            }
        }
        
        //Lay ten phuong thuc
       
        for(int i=0;i<tempList.length;i++)
        {
            if(tempList[i]!=null)
            {
                if(tempList[i].contains("(")&&!tempList[i].contains(".")&&!tempList[i].contains("+")&&!tempList[i].contains("-")&&!tempList[i].contains("*")&&!tempList[i].contains("/")&&tempList[i].contains(")")&&!tempList[i].contains("=")&&!tempList[i].contains(">")&&!tempList[i].contains("if")&&!tempList[i].contains("for")&&!tempList[i].contains("catch")&&!tempList[i].contains("new"))
                {
                    
                    tempList[i]=tempList[i].replaceAll("\\{","");
                    tempList[i]=tempList[i].replaceAll("\\}","");
                    //Xoa pham vi truy cap
                    tempList[i]=tempList[i].replace("public","");
                    tempList[i]=tempList[i].replace("protected","");
                    tempList[i]=tempList[i].replace("private","");
                    //Xoa kieu static
                    tempList[i]=tempList[i].replace("static","");
                    tempList[i]=tempList[i].trim();
                    //Phan tach bang khoang trang -- Luc nay chi con kieu tra ve va ten phương thuc
                    String[] temp = tempList[i].split(" ");
                    
                    if(temp[0].equals("void")||temp[0].equals("int")||temp[0].equals("float")||temp[0].equals("double")||temp[0].equals("String")||temp[0].equals("boolean"))
                    {
                        //Phan tu temp[0] chinh la kieu tra ve ( co hoac khong )
                        tempType=temp[0];
                        
                        temp[0]=" ";
                        //Noi tat ca mang thanh mot chuoi
                        tempList[i]=String.join(" ", temp);
                        
                        addMethod(new Method(tempType, tempList[i].trim()));
                        
                    }
                    
                    else
                    {
                       addMethod(new Method("",tempList[i])) ;
                    }
                }
                
            }
        }
        
    }
   
    
    
    public  String xuly() throws IOException {
        String s="";
        readFile();
       try
       {
        getClassInfo();
       rank=classList[0].rank;
       //classList[0].showInfo();
       s="<html>"+classList[0].toString()+"<br/>"+"<hr>"+"<br>";
       }
       catch(NullPointerException e)
       {
           System.out.println("error");
       }
       
       // System.out.println("_________________________");
       // System.out.println("Variables:");
        for(int i=0;i<countVar;i++)
        {
            //varList[i].showInfo();
            s=s+varList[i].toString()+"<br>";
        }
         //System.out.println("________________________");
         s=s+"<hr>"+"<br>";
         //System.out.println("Methods:");
        for(int i=0;i<countMethod;i++)
        {
           // methodList[i].showInfo();
            s=s+methodList[i].toString()+"<br>";
        }
        s=s+"<html/>";
        return s;
        
    }
   

}