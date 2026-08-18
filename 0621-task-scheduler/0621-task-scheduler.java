class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Count frequency of each task
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Max heap: highest frequency first
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int count : freq) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        // Stores [remaining frequency, available time]
        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {

            time++;

            // Move tasks whose cooldown has finished
            if (!cooldown.isEmpty() &&
                cooldown.peek()[1] == time) {

                maxHeap.offer(cooldown.poll()[0]);
            }

            // Execute a task if one is available
            if (!maxHeap.isEmpty()) {

                int remaining = maxHeap.poll();

                remaining--;

                if (remaining > 0) {
                    // Task can be used again after n intervals
                    cooldown.offer(new int[] {
                        remaining,
                        time + n + 1
                    });
                }
            }
        }

        return time;
    }
}