package tianming.day_26.genericity;

public class MyDBLinked<T> {
    private Node head;
    private Node end;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 双向链表添加数据
     *
     * @param value：要添加的值
     * @return ：添加是否成功
     */
    public boolean add(T value) {
        if (size == 0) {
            head = new Node(value, null, null);
            end = head;
            size++;
            return true;
        }
        end.next = new Node(value, end, null);
        end = end.next;
        size++;
        return true;
    }

    /**
     * 从双向链表中根据内容删除某个元素
     *
     * @param value ：要删除的元素
     * @return ：删除是否成功
     */
    public boolean remove(T value) {
        if (isEmpty()) throw new RuntimeException("linked is empty");
        if (value == null) {
            if (value == head.data) {
                if (size == 1) {
                    head = null;
                    end = null;
                } else {
                    head = head.next;
                    head.pre = null;
                }
                size--;
                return true;
            }
            Node mid = head;
            while (mid.next != null && mid.next.data != value) {
                mid = mid.next;
            }
            if (mid.next == null) return false;
            if (mid.next == end) {
                mid.next = null;
                end = mid;
            } else {
                mid.next.next.pre = mid;
                mid.next = mid.next.next;
            }
            size--;
            return true;
        } else {
            if (value.equals(head.data)) {
                if (size == 1) {
                    head = null;
                    end = null;
                } else {
                    head = head.next;
                    head.pre = null;
                }
                size--;
                return true;
            }
            Node mid = head;
            while (mid.next != null && mid.next.data != value) {
                mid = mid.next;
            }
            if (mid.next == null) return false;
            if (mid.next == end) {
                mid.next = null;
                end = mid;
            } else {
                mid.next.next.pre = mid;
                mid.next = mid.next.next;
            }
            size--;
            return true;
        }
    }

    /**
     * 根据内容查找双向链表
     *
     * @param value ：要查找的值
     * @return ：查找是否成功
     */
    public boolean contains(T value) {
        if (isEmpty()) throw new RuntimeException("linked is empty");
        Node mid = head;
        if (value == null) {
            while (mid != null && mid.data != value) {
                mid = mid.next;
            }
            if (mid == null) return false;
            return true;
        } else {
            while (mid != null && !value.equals(mid.data)) {
                mid = mid.next;
            }
            if (mid == null) return false;
            return true;
        }
    }

    /**
     * 从双向链表中查找内容并替换
     *
     * @param oldValue ：要替换的值
     * @param newValue ：新的值
     * @return ：是否替换成功
     */
    public boolean set(T oldValue, T newValue) {
        if (isEmpty()) throw new RuntimeException("linked is empty");
        if (oldValue == null) {
            Node mid = head;
            while (mid != null && mid.data != oldValue) {
                mid = mid.next;
            }
            if (mid == null) return false;
            mid.data = newValue;
            return true;
        } else {
            Node mid = head;
            while (mid != null && !oldValue.equals(mid.data)) {
                mid = mid.next;
            }
            if (mid == null) return false;
            mid.data = newValue;
            return true;
        }
    }

    /**
     * 根据下标添加一个元素
     *
     * @param index  : 下标
     * @param value: 添加的元素
     * @return: 添加是否成功
     */
    public boolean add(int index, T value) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index = " + index + "size = " + size);
        if (index <= size / 2) {
            if (index == 0) {
                Node newNode = new Node(value, null, head);
                if (head == null) {
                    head = newNode;
                    end = newNode;
                } else {
                    head.pre = newNode;
                    head = newNode;
                }
                size++;
                return true;
            }
            Node mid = head;
            int tag = 1;
            while (tag != index) {
                mid = mid.next;
                tag++;
            }
            Node node = new Node(value, mid, mid.next);
            mid.next = node;
            node.next.pre = node;
            size++;
            return true;
        } else {
            Node mid = end;
            int tag = size;
            while (tag != index) {
                tag--;
                mid = mid.pre;
            }
            if (mid == end) {
                mid.next = new Node(value, end, null);
                end = end.next;
            } else {
                Node node = new Node(value, mid, mid.next);
                mid.next = node;
                node.next.pre = node;
            }
            size++;
            return true;
        }
    }

    /**
     * 根据下标删除下标对应内容
     *
     * @param index: 要删除的下标位置
     * @return ：被删除的元素
     */
    public boolean remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index = " + index + "size = " + size);
        if (index <= size / 2) {
            if (index == 0) {
                if (head == null) {
                    head = null;
                    end = null;
                } else {
                    head = head.next;
                    head.pre = null;
                }
                size--;
                return true;
            }
            Node mid = head;
            int tag = 1;
            while (tag != index) {
                mid = mid.next;
                tag++;
            }
            mid.pre.next = mid.next;
            mid.next.pre = mid.pre;
            size--;
            return true;
        } else {
            Node mid = end;
            int tag = size;
            while (tag != index) {
                tag--;
                mid = mid.pre;
            }
            if (mid == end) {
                end = end.pre;
                end.next = null;
            } else {
                mid.pre.next = mid.next;
                mid.next.pre = mid.pre;
            }
            size--;
            return true;
        }
    }

    /**
     * 根据下标查找数据
     *
     * @param index ：下标
     * @return ：下标所在的结点数据
     */
    public T getData(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index = " + index + "size = " + size);
        Node mid;
        if (index <= size / 2) {
            mid = head;
            int tag = 0;
            while (tag != index) {
                mid = mid.next;
                tag++;
            }
        } else {
            mid = end;
            int tag = size;
            while (tag != index) {
                mid = mid.pre;
                tag--;
            }
        }
        return mid.data;
    }

    /**
     * 根据下标查找数据并替换
     *
     * @param index   ：下标
     * @param newData ：新数据
     * @return ：旧数据
     */
    public T setData(int index, T newData) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index = " + index + "size = " + size);
        Node mid;
        if (index <= size / 2) {
            mid = head;
            int tag = 0;
            while (tag != index) {
                mid = mid.next;
                tag++;
            }
        } else {
            mid = end;
            int tag = size;
            while (tag != index) {
                mid = mid.pre;
                tag--;
            }
        }
        T oldData = mid.data;
        mid.data = newData;
        return oldData;

    }

    class Node {
        T data;
        Node pre;
        Node next;

        public Node(T data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
//                    ", pre=" + pre +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Demo{" +
                "head=" + head +
                '}';
    }
}

