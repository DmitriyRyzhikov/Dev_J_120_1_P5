package Dev_J_120;


import java.time.LocalTime;

public class Main {
    
//Константы, с помощью которых можно задать направление итерации по коллекции.    
    static final boolean FORVARD_DIRECTION = true;
    static final boolean REVERSE_DIRECTION = false;

    public static void main(String[] args) {
                
/* Код полностью взят из 3 части лаб.работы №3 курса 110
      и доработан для использования с разными типами данных.  
        
        Для опытов создано три разнотипных списка:
       - с типом данных String;
       - с типом данных Integer;
       - с типом данных LocalTime.
*/
    String[] stringData = {"кот", "лошадь", "корова", "обезьяна", "лебедь", "сова"}; 
    Integer[] intData = {100, 200, 300, 400, 500};
    LocalTime [] timeData = {LocalTime.MIDNIGHT, LocalTime.NOON, LocalTime.of(11, 45), LocalTime.of(9, 25), LocalTime.of(0, 15)};  
    
    DoublyList<String> stringList = new DoublyList<>();
    stringList.addFromArrayFirst(stringData); 
        
    DoublyList<Integer> intList = new DoublyList<>();
    intList.addFromArrayFirst(intData);
        
    DoublyList<LocalTime> timeList = new DoublyList<>();
    timeList.addFromArrayFirst(timeData);
    
// метод printAllList() выводит содержимое всех трех списков в консоль:
        System.out.println("Исходные списки:");
    stringList.printAll();
    intList.printAll();
    timeList.printAll();
    System.out.println(); 
    
//перебираем при помощи оператора «for-each» все содержимое списка:    
    System.out.println("Перебираем список stringList по порядку с помощью оператора for-each и метода forEach()");
           
    for(String t : stringList){ 
        System.out.print(t + " ");
    }
// или тоже самое при помощи метода forEach 
    System.out.println();
    stringList.forEach(x-> System.out.print(x + " "));
    System.out.println("\n"); 

/*Перебираем при помощи оператора «for-each» все содержимое списка в обратном порядке:
Направление итерации задается методом setDirection(). При этом какие-либо изменения
в самой коллекции(в данном случае - списке) не происходит и порядок элементов в ней не меняется.
Указанный метод подменяет лишь итератор, который находится под капотом у for-each и forEach(). 
При этом, по умолчанию, назначен итератор для прямого направления и к коллекциям, к которым
метод setDirection() не применялся, действует именно он. Для возврата к нормальному порядку
итерации, необходимо вновь применить к коллекции метод setDirection(), передав в него в качестве
параметра константу FORVARD_DIRECTION.    
*/       
    System.out.println("Перебираем список stringList в обратном порядке с помощью оператора for-each и метода forEach()");    

    stringList.setDirection(REVERSE_DIRECTION); 

    for(String t : stringList){ 
        System.out.print(t + " ");
    }
// или тоже самое при помощи метода forEach 
    System.out.println();
    stringList.forEach(x-> System.out.print(x + " "));
    System.out.println("\n"); 

/* Перебираем при помощи оператора «for-each» содержимое списка intList от головного узла до узла 
 с заданным значением; если список заданного значения не содержит, то должно быть перебрано всё содержимое списка.
*/  
    System.out.println("Перебираем список intListList от головного узла до узла с значением 300\n"
                       + "с помощью оператора for-each и метода forEach()");    
    for(int i : intList){
        System.out.print(i + " ");
        if(i == 300)
           break;
        }
    System.out.println();
/*    
 Либо, используем перегруженный стандартный метод forEach, в который добавлен параметр T toElement до совпадения с которым
будет происходить перебор списка.   
*/    
    intList.forEach(300, x -> System.out.print(x + " "));
    System.out.println("\n");
            
/* Перебираем при помощи оператора «for-each» содержимое списка intList от узла с заданным значением 
 до конца списка. Если список заданного значения не содержит, то ничего происходить не должно. 
*/  
    System.out.println("Перебираем список intListList от узла с заданным значением 300 до хвоста списка\n"
                       + "с помощью оператора for-each и метода forEach()");    
        boolean a = false;
        for(int s : intList){
            if((s == 300) == a)  
                continue;
            a = true;
            System.out.print(s + " ");
        }
    System.out.println();       
/*    
 Либо, используем перегруженный стандартный метод forEach, в который добавлен параметр T fromElement, после 
совпадения с которым будет происходить заданное действие (список перебирается весь, но заданное действие 
происходит после совпадения элемента с параметром fromElement.     
*/ 
    intList.forEach(x -> System.out.print(x + " "), 300);    
    System.out.println("\n");       

/* Перебираем при помощи оператора «for-each» содержимое списка timeList от хвостового узла до узла 
 с заданным значением 11:45. Если список заданного значения не содержит, то должно быть перебрано всё содержимое списка.
 Если используется For-Each Loop, то перед ним следует изменить направление итерации в коллекции на обратное. 
 методом setDirection. В этом случае, кроме For-Each Loop, сработает и использованный выше метод 
 forEach(Consumer<? super T> action, T fromElement). Если направление итерации не менять, решить задачу
 перебора от хвоста до заданного значения сможет решить перегруженный метод forEach, в который, кроме  
 параметра T fromElement, добавлен параметр, задающий направление итерации. См.ниже.   
*/  
    System.out.println("Перебираем список timeList от хвостового узла до узла с значением 11:45\n"
                       + "с помощью оператора for-each и метода forEach()");    
    
    timeList.setDirection(REVERSE_DIRECTION); 
    
    for(LocalTime i : timeList){
        System.out.print(i + " ");
        if(i.equals(LocalTime.of(11, 45)))
           break;
        }

    System.out.println();

//возвращаем timeList к нормальному порядку итерации и используем forEach с тремя параметрами...    
    
    timeList.setDirection(FORVARD_DIRECTION);  
    
    timeList.forEach(LocalTime.of(11, 45), x -> System.out.print(x + " "), REVERSE_DIRECTION);
    System.out.println("\n"); 
    
/* Перебираем при помощи оператора «for-each» содержимое списка timeList от узла с заданным значением 11:45 
 до головного узла. Если список заданного значения не содержит, то ничего не происходит.
 Если используется For-Each Loop, то перед ним следует изменить направление итерации в коллекции на обратное. 
 методом setDirection. В этом случае, кроме For-Each Loop, сработает и использованный выше метод 
 forEach(Consumer<? super T> action, T fromElement). Если направление итерации не менять, решить задачу
 перебора от хвоста до заданного значения сможет решить перегруженный метод forEach, в который, кроме  
 параметра T fromElement, добавлен параметр, задающий направление итерации. См.ниже.   
*/  
    System.out.println("Перебираем список timeList от узла с значением 11:45 до головного узла\n"
                       + "с помощью оператора for-each и метода forEach()");    
    
    timeList.setDirection(REVERSE_DIRECTION); 
    
    a = false;
    for(LocalTime s : timeList){
        if(s.equals(LocalTime.of(11, 45)) == a)  
            continue;
        a = true;
        System.out.print(s + " ");
        }
    System.out.println(); 

//возвращаем timeList к нормальному порядку итерации и используем forEach с тремя параметрами...    
    
    timeList.setDirection(FORVARD_DIRECTION);  
    
    timeList.forEach(x -> System.out.print(x + " "), LocalTime.of(11, 45), REVERSE_DIRECTION);
    System.out.println("\n"); 
    
/* Список доступных методов, доставшихся в наследство от 110 курса:
        - Метод addFirst(String data) добавляет значения в начало списка;
        - Метод addFromArrayFirst(String[] data) добавляет все значения заданного массива в начало списка с сохранением порядка;
        - Метод extractFirst() извлекает и возвращает значение из начала списка без его удаления из списка;
        - Метод extractFirstAndRemove() извлекает и возвращает значение из начала списка с удалением его из списка;
        - Метод addToEnd(String data) добавляет значение в конец списка;
        - Метод extractFromEnd() извлекает и возвращает значение из конца списка без его удаления;
        - Метод extractFromEndAndRemove() извлекает и возвращает значение из конца списка с удалением его из списка;
        - Метод addFromArrayEnd(String[] data) добавляет все значения заданного массива в конец списка с сохранением порядка;
        - Метод isInList(String toEquals) определяет, содержит ли список переданное в метод значение toEquals, или нет. 
          Возвращает true, если содержит и false, если такого значение в списке нет;
        - Метод isEmptyList(), определяет, является ли список пустым, или нет. 
          Возвращает true, если список пустой и false, если не пустой;
        - Метод printAll() - осуществляет печать всех значений списка от первого элемента к последнему; 
          Если список пустой, выводит сообщение "Элементы списка отсутствуют, список пустой.";
        - Метод printAllBack() - осуществляет печать всех значений списка в обратном порядке - от последнего элемента к первому; 
          Если список пустой, выводит сообщение "Элементы списка отсутствуют, список пустой.";
        - *Метод removeIfHas(String toRemove) удаляет из списка, переданное в метод значение toRemove. 
          Если значения в списке нет, то ничего не происходит; 
        - Метод mergeLists(DoublyList listToMerge). Список поглощает список listToMerge с добавлением значений в начало первого списка; после поглощения список listToMerge очищается;
        - Метод mergeListsBack(DoublyList listToMerge). Список поглощает список listToMerge с добавлением значений в конец первого списка; после поглощения список listToMerge очищается;
        - Метод mergeCollection(Collection<String> collection) добавляет все значения заданной коллекции collection в начало списка с сохранением порядка.
          Коллекция — любой объект, реализующий интерфейс java.lang.Iterable;
        - Метод mergeCollectionToEnd(Collection<String> collection) добавляет все значения заданной коллекции collection в конец списка с сохранением порядка.
          Коллекция — любой объект, реализующий интерфейс java.lang.Iterable;
*/        
    }
}
