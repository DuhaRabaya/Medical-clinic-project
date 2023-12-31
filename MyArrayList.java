public class MyArrayList<T> {
        int size=0;
        int capacity=1;
        T []arr=(T[])new Object[capacity];
        public MyArrayList()
        {
        }
        public void ensurecapacity()
        {
            if(size==capacity)
            {
                capacity*=2;
                T []arr2=(T[]) new Object [capacity];
                for(int i=0 ;i<size ; i++)
                {
                    arr2[i]=arr[i];
                }
                arr=arr2;
            }
        }
        public void add(T x)
        {
            ensurecapacity();
            arr[size]=x;

            size++;
        }
        public T get(int x)
        {
            if(x<0 || x>=size)
                throw new ArrayIndexOutOfBoundsException("index not right");

            else return arr[x];
        }
        public String tostring()
        {
            String res="[";
            for(int i=0 ;i<size ;i++)
            {
                if(i==size-1) res+=arr[i];
                else res+=arr[i]+" , ";
            }
            res+=']';
            return res;
        }
        public int getSize()
        {
            return size;
        }
        public T getlast()
        {
            if(size==0) throw new ArrayIndexOutOfBoundsException();
            return arr[size-1];
        }
        public void removelast()
        {
            if(size==0) System.out.println("empty");
            else
            {
                size--;
            }
        }
        public void addbyindex( int index,T value)
        {
            if(index>=0 && index<=size)
            {
                ensurecapacity();
                for (int i = size; i > index; i--)
                    arr[i] = arr[i-1];

                arr[index] = value;
                size++;
            }
            else throw new ArrayIndexOutOfBoundsException();

        }

        public int indexof(T value)
        {
            for(int i=0 ;i<size ;i++)
            {
                if(arr[i]==value) return i;
            }
            return -1;
        }
        public T removebyindex(int index)
        {
            T value=arr[index];
            if(size ==0  || index<0 || index>=size) throw new ArrayIndexOutOfBoundsException();
            for(int i=index ;i<size-1 ;i++)
                arr[i]=arr[i+1];

            size--;
            return value;

        }
        public int IndexOf(T value)
        {
            for(int i=0 ;i<size ;i++)
                if (get(i).equals(value)) {
                    return i;
                }
            return -1;
        }


    }


