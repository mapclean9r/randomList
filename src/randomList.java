import java.util.Random;

public class randomList<T> {

        private Node<T> head;
        private int size = 0;

        public randomList() {
            this.head = null;
        }

        public void add(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

    public T delete(T data) {
        try {
            if (head == null) {
                return null;
            }

            if (head.data.equals(data)) {
                T deletedData = head.data;
                head = head.next;
                size--;
                return deletedData;
            }

            Node<T> current = head;
            while (current.next != null && !current.next.data.equals(data)) {
                current = current.next;
            }

            if (current.next == null) {
                return null;
            }

            T deletedData = current.next.data;
            current.next = current.next.next;
            size--;
            return deletedData;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public T pick() {
        try {
            if (size == 0) {
                return null;
            }

            Random random = new Random();
            int randomIndex = random.nextInt(size);
            T data = get(randomIndex);
            delete(data);
            return data;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public T get(int index) {
        try {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }

            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current.data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean contains(T data) {
            Node<T> current = head;
            while (current != null) {
                if (current.data.equals(data)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        public int size() {
            return size;
        }

    public void printListForm() {
        Node<T> current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null){
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.print("]");
    }


}
