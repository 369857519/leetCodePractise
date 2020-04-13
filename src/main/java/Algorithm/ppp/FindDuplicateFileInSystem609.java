package Algorithm.ppp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 祁连山 on 2019/2/19.
 */
public class FindDuplicateFileInSystem609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> recordMap = new HashMap<>();
        String pattern = "(.+)\\((.+)\\)";
        Pattern r = Pattern.compile(pattern);
        for (int i = 0; i < paths.length; i++) {
            String[] strings = paths[i].split(" ");
            String currentPath = strings[0];
            for (int j = 0; j < strings.length; j++) {
                Matcher matcher = r.matcher(strings[j]);
                if (matcher.find()) {
                    String name = matcher.group(0);
                    String content = matcher.group(1);
                    if (recordMap.get(content) == null) {
                        List<String> list = new ArrayList<>();
                        list.add(currentPath + name);
                        recordMap.put(content, list);
                    } else {
                        recordMap.get(content).add(currentPath + name);
                    }
                }
            }
        }
        return (List<List<String>>)recordMap.values();
    }
}
