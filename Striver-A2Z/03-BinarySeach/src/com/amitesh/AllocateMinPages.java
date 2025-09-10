package com.amitesh;

public class AllocateMinPages {
    public static void main(String[] args) {
        // Q. Allocate Minimum Pages
        int[] books = {12, 34, 67, 90};
        int students = 2;
        System.out.println(findPages(books, students));
    }
    public static int findPages(int[] books, int students) {
        /*
        IDEA:
        - We want to minimize the maximum number of pages allocated to a student.
        - Each student must get a contiguous set of books.
        - The answer lies between:
            * max(pages in a single book)   → lower bound
            * sum of all pages (1 student) → upper bound

        APPROACH:
        1. Use Binary Search between [maxBookPages .. totalPages].
        2. For a mid (maxPages), check if it's possible to allocate books to all students
           such that no student reads more than mid-pages.
        3. If possible, try smaller values (move left).
           If not, try larger values (move right).
        4. Return the smallest possible valid maxPages.

        TIME COMPLEXITY: O(n log(sum of pages))
        SPACE COMPLEXITY: O(1)
        */

        int n = books.length;

        if (n < students) return -1; // Not enough books for each student.

        //Find sum of pages and max pages in a single book
        int totalPages = 0;
        int maxBookPages = 0;
        for (int pages : books) {
            totalPages += pages;
            maxBookPages = Math.max(maxBookPages, pages);
        }

        int low = maxBookPages;  // At least the max book must be allocated
        int high = totalPages;   // At most, one student gets all books
        int result = -1;

        // Binary Search on possible maximum pages
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(books, students, mid)) {
                result = mid;      // Possible answer, try better (smaller)
                high = mid - 1;
            } else {
                low = mid + 1;     // Not possible, need to increase max pages
            }
        }
        return result;
    }

    // Helper function: checks if allocation possible with given maxPages
    private static boolean canAllocate(int[] books, int students, int maxPages) {
        int requiredStudents = 1;
        int currentPages = 0;

        for (int pages : books) {
            currentPages += pages;

            if (currentPages > maxPages) {
                // Assign current book to next student
                requiredStudents++;
                currentPages = pages;
            }

            // If students needed exceeds allowed, allocation not possible
            if (requiredStudents > students) return false;
        }
        return true;
    }
}
