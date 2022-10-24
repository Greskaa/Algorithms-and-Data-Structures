public class Array<E>  //angle brackets mean generics
{
    private E data[]; //object(s) of data type E is declared (the data type is yet not defined)
    private int size;

    //constructor that creates an empty array of size "size"
    //the class array stores array elements of data type E
    public Array(int size)
    {
        this.data = (E[]) new Object[size]; //dynamically allocated
        this.size = size;
    }

    //set method puts the object "o" in the array data on position "position"
    public void set(int position, E o)
    {
        if (position >= 0 && position < size) //checks to stay in range of the array size
        {
            data[position] = o;
        }
        else
        {
            System.out.println("Element could not be added to the arrray");
        }
    }

    //get method returns the element in position "position"
    public E get(int position)
    {
        if (position >= 0 && position < size) //checks to stay in range of the array size
        {
            return data[position];
        }
        else
        {
            System.out.println("The position given is not valid");
        }
        return null;
    }

    //method getLength returns the size of the array
    public int getLength()
    {
        return size; //size represents how many positions there are allocated for the array
                     //(not how many elements are stored there)
    }

    //method that finds an element by its value -> returns its index
    public int find(E o)
    {
        for (int i=0; i<size; i++)
        {
            if (o.equals(data[i])) //equals method is used to compare objects in a class and not == sign
                return i;
        }
        return -1; //means that the element was not found
    }

    //method that inserts an element o in the position "position"
    public void insert(int position, E o)
    {
        //before all we check if the position is within range
        if(position >= 0 && position <size)
        {
            E[] newData = (E[]) new Object[size+1]; //resize the storage array
            for (int i=0; i<size; i++)
            {
                newData[i] = data[i]; //copy the data prior to the insertion
            }

            newData[position] = o; //insert the new element

            for (int i=0; i<size; i++)
            {
                newData[i+1] = data[i]; //move the data after the insertion
            }

            //replace the storage with the array
            data = newData; //old array points to the new created array
            size = size + 1; //size is incremented by one
        }
    }

    //method that deletes an element o in the position "position"
    public void delete(int position)
    {
        if (position >= 0 && position < size)
        {
            E[] newData = (E[]) new Object[size-1]; //resize the storage array
            for (int i=0;  i<position; i++)
            {
                newData[i] = data[i]; //copy the data prior to the deletion
            }
            for (int i=position+1; i<size; i++)
            {
                newData[i-1] = data[i]; //copy the data after the deletion
                                        //places the data one index to the left
            }
            //replace the storage with the new array
            data = newData; //old array points to the new created array
            size = size-1; //size is decremented by one
        }
    }

    //method for resizing the array
    //usually used for increasing the size of the array
    public void resize(int newSize)
    {
        E[] newData = (E[]) new Object[newSize]; //resize the storage array by the new size
        int copySize = size;
        if (newSize < size)
            copySize = newSize;

        for (int i=0; i<copySize; i++)
        {
            newData[i] = data[i]; //copy the data
        }
        //replace the storage with the array
        data = newData;
        size = newSize;
    }
}
