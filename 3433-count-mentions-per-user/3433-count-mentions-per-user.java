import java.util.*;

class Solution {
    static class Ev {
        String type;
        long time;
        String payload;
        Ev(String type, long time, String payload) {
            this.type = type;
            this.time = time;
            this.payload = payload;
        }
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        // Parse events into Ev objects
        List<Ev> list = new ArrayList<>(events.size());
        for (List<String> e : events) {
            String type = e.get(0);
            long time = Long.parseLong(e.get(1));
            String payload = e.get(2);
            list.add(new Ev(type, time, payload));
        }

        // Sort by time, and ensure OFFLINE are processed before MESSAGE at same timestamp
        Collections.sort(list, (a, b) -> {
            if (a.time != b.time) return Long.compare(a.time, b.time);
            if (a.type.equals(b.type)) return 0;
            if (a.type.equals("OFFLINE") && b.type.equals("MESSAGE")) return -1;
            if (a.type.equals("MESSAGE") && b.type.equals("OFFLINE")) return 1;
            return a.type.compareTo(b.type);
        });

        long[] counts = new long[numberOfUsers];
        long[] offlineEnd = new long[numberOfUsers]; // time when user becomes online again (initially 0 => online)

        for (Ev ev : list) {
            if (ev.type.equals("OFFLINE")) {
                // payload is user id
                int uid = Integer.parseInt(ev.payload);
                // user offline starting at ev.time, returns at ev.time + 60
                offlineEnd[uid] = ev.time + 60;
            } else if (ev.type.equals("MESSAGE")) {
                String mentions = ev.payload;
                long t = ev.time;

                if (mentions.equals("ALL")) {
                    // increment every user
                    for (int i = 0; i < numberOfUsers; i++) counts[i]++;
                } else if (mentions.equals("HERE")) {
                    // increment only those online at time t (t >= offlineEnd[i])
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (t >= offlineEnd[i]) counts[i]++;
                    }
                } else {
                    // tokens like "id3 id2 id3" — duplicates count separately
                    String[] toks = mentions.trim().split("\\s+");
                    for (String tok : toks) {
                        if (tok.length() == 0) continue;
                        if (tok.startsWith("id")) {
                            // parse after "id"
                            int id = Integer.parseInt(tok.substring(2));
                            counts[id]++;
                        } else {
                            // defensive fallback: try parse as integer
                            try {
                                int id = Integer.parseInt(tok);
                                counts[id]++;
                            } catch (NumberFormatException ex) {
                                // ignore unexpected token
                            }
                        }
                    }
                }
            } else {
                // unknown event type: ignore (or could throw)
            }
        }

        // convert to int[] as method signature requires
        int[] result = new int[numberOfUsers];
        for (int i = 0; i < numberOfUsers; i++) result[i] = (int) counts[i];
        return result;
    }
}
