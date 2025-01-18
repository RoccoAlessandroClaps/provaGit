package it.isa.pattern;

// da inserire in un file MyIterator.java
interface MyIterator {
    void rewind();               //per riposizionare l'iteratore all'inizio
    int nextElement();           // dice qual è l'altro elemento nella collezione
    boolean hasNextElement();
}

// da inserire in un file MyCollection.java
interface MyCollection {
    public MyIterator getIter();
}

// da inserire in un file MyListArray.java
class MyListArray implements MyCollection {
    public int[] lista;

    public MyListArray(int n) {                  // costruttore
        lista = new int[n];

        for(int i = 0; i < n; i++) {
            lista[i] = i * 10;
        }
    }

    public MyIterator getIter() {
        return new MyListIterator(this);
    }
}

// da inserire in un file MyListIterator.java
class MyListIterator implements MyIterator {
    private int index = -1;
    private int[] lista;

    public MyListIterator(MyListArray la) {       //costruttore
        lista = la.lista;
    }

    public void rewind() {                       // tre metodi dell'interfaccia
        index = -1;
    }

    public int nextElement() {
        index++;
        return lista[index];
    }

    public boolean hasNextElement() {
        return index < lista.length - 1;
    }
}

// 'client'
public class IteratorPattern {
    public static void esegui() {
        System.out.println("Iterator pattern");
        MyCollection la = new MyListArray(10);
        MyIterator li = la.getIter();

        while(li.hasNextElement()) {
            System.out.println("Element: " + li.nextElement());
        }
    }
}
