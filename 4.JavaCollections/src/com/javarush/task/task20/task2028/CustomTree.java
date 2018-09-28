package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Serializable, Cloneable {
    Entry<String> root = new Entry<String>("0");
    LinkedList<Entry<String>> entries = new LinkedList<>();




    public CustomTree(){
     //   this.root = root;
        entries.add(root);
    }


    @Override
    public String get(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
     //   return null;
    }

    @Override
    public int size() {
        return entries.size()-1;
    }

    @Override
    public String set(int index, String element) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean add(String element){
        Entry<String> entry = new Entry<>(element);
        for(int i = 0; i<entries.size(); i++){
            if(entries.get(i).isAvailableToAddChildren()){
                entry.parent = entries.get(i);
                if(entries.get(i).leftChild==null){
                    entries.get(i).leftChild = entry;
                    entries.add(entry);
                }
                else{
                    entries.get(i).rightChild = entry;
                    entries.get(i).checkChildren();
                    entries.add(entry);
                }
                break;
            }
        }
        int line = (int) Math.floor(Math.log(entries.size())/Math.log(2));
        entry.lineNumber = line+1;
        return true;
    }

    public String getParent(String child){

        for(int i = 0; i<entries.size(); i++){
            if(entries.get(i).elementName.equals(child)){
                return entries.get(i).parent.elementName;
            }
        }
        return null;
    }

    @Override
    public String remove(int index) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) throws UnsupportedOperationException{
        if(!(o instanceof String)){
            throw new UnsupportedOperationException();
        }
        for(int i = 0; i<entries.size(); i++){
            if(entries.get(i).elementName.equals(o)){
                Entry <String> root = entries.get(i);
                removeChildren(root);
                boolean free = entries.size()<Math.pow(2, root.lineNumber-1);

                if(root.parent.leftChild!= null && root.parent.leftChild.equals(root)){
                    root.parent.leftChild = null;
                }
                else {
                    root.parent.rightChild = null;
                }
                if(free){
                    for(int j = (int) (Math.pow(2, root.lineNumber-2)-1); j<entries.size(); j++){
                        entries.get(j).availableToAddLeftChildren = true;
                        entries.get(j).availableToAddRightChildren = true;
                    }
                }

                break;
            }
        }

        return true;
    }

    private void removeChildren(Entry<String> toDelete){

        entries.remove(toDelete);
        if(toDelete.leftChild!=null){
            removeChildren(toDelete.leftChild);
        }
        if(toDelete.rightChild!= null){
            removeChildren(toDelete.rightChild);
        }
    }


    @Override
    public List<String> subList(int fromIndex, int toIndex) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    @Override
    protected void removeRange(int fromIndex, int toIndex) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean addAll(int index, Collection<? extends String> c) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;
        Entry<String> root;

        public Entry (String n){
            this.elementName = n;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public void checkChildren(){
            if(leftChild!=null){
                availableToAddLeftChildren = false;
            }
            if (rightChild!=null){
                availableToAddRightChildren = false;
            }
        }
        public boolean isAvailableToAddChildren (){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
