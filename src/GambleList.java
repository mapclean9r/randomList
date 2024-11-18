import java.util.Random;

public class GambleList<T> {

        private Node<T> nodeData;
        private int size = 0;

        public GambleList() {
            this.nodeData = null;
        }

        public GambleList<T> add(T data) {
            Node<T> newNode = new Node<>(data);
            if (nodeData == null) {
                nodeData = newNode;
            } else {
                Node<T> current = nodeData;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
            return this;
        }

    public T roll() {
        try {
            if (size == 0) {
                return null;
            }

            Random random = new Random();
            int randomIndex = random.nextInt(size);
            T data = get(randomIndex);
            return delete(data);

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

            Node<T> current = nodeData;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current.data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int size() {
            return size;
        }

    public void printListForm() {
        Node<T> current = nodeData;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null){
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.print("]\n");
    }

    private T delete(T data) {
        try {
            if (nodeData == null) {
                return null;
            }

            if (nodeData.data.equals(data)) {
                T deletedData = nodeData.data;
                nodeData = nodeData.next;
                size--;
                return deletedData;
            }

            Node<T> current = nodeData;
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


}
