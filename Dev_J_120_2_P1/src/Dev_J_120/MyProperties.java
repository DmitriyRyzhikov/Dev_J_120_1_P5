
package Dev_J_120;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class MyProperties {
    
    private Properties properties;
    private File propertiesFile;

//Конструктор по умолчанию, создающий пустой набор свойств.    
    public MyProperties(){
        properties = new Properties();
        }
//Конструктор, загружающий свойства из заданного файла. Файл задан экземпляром класса java.io.File;  
    public MyProperties(File propertiesFile) throws IOException{
        this();
        this.propertiesFile = Objects.requireNonNull(propertiesFile, "propertiesFile must not be null");
        if (!propertiesFile.exists()) 
            propertiesFile.createNewFile();
        properties.load(new FileReader(propertiesFile));        
    }
//Конструктор, загружающий свойства из заданного файла. Файл задан строкой с именем файла;          
    public MyProperties(String fileName) throws IOException{
        this();
        if (fileName == null && !fileName.isEmpty()) 
            throw new IllegalArgumentException("fileName can't be empty");
        propertiesFile = new File(fileName.trim()); 
        if (!propertiesFile.exists()) 
            propertiesFile.createNewFile();
        properties.load(new FileReader(propertiesFile));   
    }
// Метод, возвращающий набор свойств из нашего properties в виде пар <имя свойства(ключ)=значение>, хранящихся в HashMap.  
    public Map<String, String> getAllMap(){
        Map<String, String> map = new HashMap<>();
        properties.keySet().forEach((e) -> {
            String key = e.toString();
            String value = properties.getProperty(key);
            map.put(key, value);
        });
        return map;
    }
/*Метод, возвращающий значение свойства с заданными именем; если 
  свойства с таким именем нет, то метод должен возвращать null;
*/
    public String getPropertiesValue(String propertiesName) {
        return properties.getProperty(propertiesName); 
}
/*Метод устанавливающий значение свойства с заданными именем; если 
  свойство с таким именем есть, то метод задаёт свойству новое значение;
*/ 
    public void setPropertiesValue(String propertiesName, String propertiesValue){
        properties.setProperty(propertiesName, propertiesValue);
    }
//Метод, проверяющий наличие свойства с заданными именем;
    public boolean propertyExist(String propertiesName){
        return properties.containsKey(propertiesName);
}
/*Метод, удаляющий свойство с заданными именем; если свойства 
  с таким именем нет, то метод ничего не делает;    
*/
    public void removeProperty(String propertiesName){
        properties.remove(propertiesName);
    }
/*Метод без параметров, сохраняющий набор свойств в в тот же файл, откуда он ранее был 
загружен, либо в который сохранялся; если файл ранее не загружался и не сохранялся, 
то должно выбрасываться исключение; (при ошибке должно выбрасываться исключение 
подходящего типа):
*/
    
}
