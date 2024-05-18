public class Library {

    public static class Book {
        private String title;
        private String author;
        private int year;

        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "'" + title + "' by " + author + " (" + year + ")";
        }
    }

    public static void mergeSortBooks(Book[] books, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSortBooks(books, left, mid);
            mergeSortBooks(books, mid + 1, right);

            merge(books, left, mid, right);
        }
    }

    private static void merge(Book[] books, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Book[] leftArray = new Book[n1];
        Book[] rightArray = new Book[n2];

        System.arraycopy(books, left, leftArray, 0, n1);
        System.arraycopy(books, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i].getTitle().compareTo(rightArray[j].getTitle()) <= 0) {
                books[k] = leftArray[i];
                i++;
            } else {
                books[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            books[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            books[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void printBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("Madol Doowa", "Martin Wickramasinghe", 1947),
            new Book("Magul Kama", "Ediriweera Sarachchandra", 1956),
            new Book("Hathpana", "Kumaratunga Munidasa", 1949),
            new Book("Heen Saraya", "Karunasena Jayalath", 1963),
            new Book("Kaliyugaya", "Martin Wickramasinghe", 1957),
			new Book("Amba Yahaluwo", "T. B. Ilangaratne", 1957)
        };
		
		System.out.println("\n\nIC 4302 - Programming - III");
		System.out.println("======================================");
		System.out.println("\n\nFinal Assignment (University of Colombo - Faculty of Technology)");
		System.out.println("\n=====Efficiently Managing Large Library Collections with Merge Sort=====");
        System.out.println("\n=========Books before sorting=========");
        printBooks(books);

        mergeSortBooks(books, 0, books.length - 1);

        System.out.println("\n=========Books after sorting=========");
        printBooks(books);
    }
}
