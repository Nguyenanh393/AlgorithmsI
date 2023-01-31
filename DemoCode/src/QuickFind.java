import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFind {
    private int[] id;    // tạo mảng và gán giá trị id[i] = i
    private int count;   // số thành phần

    public QuickFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    // trả về giá trị của id[p]
    public int find(int p) {
        validate(p);
        return id[p];
    }

    // ném ngoại lệ nếu p >= n hoặc < 0
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    // thuật toán Quick-Find
    // lấy p, q và so sánh id[p], id[q]
    // id[p] == id[q] -> true, không thì false
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    // lấy giá trị id[p] tương ứng với tham số pid
    // lấy gí trị id[q] tương ứng với tham số qid
    // duyệt toàn bộ mảng
    // tìm ô có gí trị bằng id[p], gán ô đó = id[q]
    // Lỗi: sử dụng id[p] để so sánh mỗi lần lặp thay vì pid
    // Lý do: khi i = p, id[p] sẽ tự cập nhật thành qid
    // => Sai (Lý do cá nhân =)))) nghĩ thế á)
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pID = id[p];
        int qID = id[q];   // giảm số lượng lần truy vấn trong dãy

        // p, q cùng 1 thành phần (liên thông???) -> bỏ qua
        if (pID == qID) return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFind uf = new QuickFind(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
// nguồn:   code: https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/QuickFindUF.java.html
//          dịch: https://docs.google.com/document/d/1NRZ24nHrJ5pUigFULNx-BPZ7HZ4nRkhV0Ri3NhZOZfw/edit