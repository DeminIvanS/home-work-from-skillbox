import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileWriter {
    private HashSet hashSet = new HashSet();
    private TreeSet set;


    static LinkedList treeSiteSet = new LinkedList();

    public void fileWriter(HashSet setLinks) {
        hashSet = setLinks;
        set = stringBuilder(hashSet);
        String treeSiteLink = "";
        treeSiteSet = treeBuilder();
        for (Object obj : treeSiteSet) {
            treeSiteLink = treeSiteLink + obj.toString();
        }
        {
            try {

                Files.write(Paths.get("SiteMap.txt"), treeSiteLink.toString().replaceAll(",", "").getBytes());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    private Object getParent(String link) {
        Object parent = null;
        String regex = "/";
        String[] tokensLinks = link.toString().split(regex);
        int numTokenForComparison = tokensLinks.length - 2;
        String tokenLinksForRegex = "/" + tokensLinks[numTokenForComparison] + "/";
        if (tokensLinks.length <= 4) {
            parent = "родитель";
        } else {
            for (Object obj : set) {
                String[] tokensHashSet = obj.toString().split(regex);
                String tokenSetForRegex = "/" + tokensLinks[numTokenForComparison] + "/";
                if (tokensLinks.length - 1 == tokensHashSet.length) {
                    String[] doubleTokenLink = link.toString().split(tokenLinksForRegex);
                    String[] doubleTokensHash = obj.toString().split(tokenSetForRegex);
                    String parentHashPath = doubleTokensHash[0];
                    String parentLinkPath = doubleTokenLink[0];
                    String str = "\t" + parentHashPath;
                    if (str.contains(parentLinkPath)) {
                        parent = parentHashPath;
                        return parent;
                    }
                }
            }
        }
        return parent;
    }

    private LinkedList treeBuilder() {
        LinkedList sortedLinkedList = new LinkedList<>();
        LinkedList reversLinkedList = new LinkedList<>();
        sortedLinkedList.addAll(set);
        for (Object obj : set) {
            sortedLinkedList.remove(obj);
            sortedLinkedList.add(0, obj);
        }
        reversLinkedList.addAll(sortedLinkedList);
        for (Object obj : reversLinkedList) {
            int placeElement = sortedLinkedList.indexOf(obj);
            sortedLinkedList.remove(placeElement);
            String parent = (String) getParent(obj.toString());
            if (parent == "родитель") {
                sortedLinkedList.add(0, obj);
            } else if (parent == null) {
            } else {
                int placeParentElement = sortedLinkedList.indexOf(parent);
                sortedLinkedList.add(placeParentElement + 1, obj);
            }
        }
        return sortedLinkedList;
    }

    private static TreeSet stringBuilder(HashSet list) {
        HashSet set = new HashSet();
        TreeSet list1 = new TreeSet();
        String lineBreak = "\n";
        String tab = "\t";
        char regex = '/';
        for (Object obj : list) {
            String linesBuilder = "";
            int depthNesting = 0;
            for (int i = 0; i < obj.toString().length(); i++) {
                if (obj.toString().charAt(i) == regex) {
                    depthNesting++;
                    if (depthNesting > 3) {
                        linesBuilder = linesBuilder + tab;
                    }
                }
            }
            linesBuilder = linesBuilder + obj + lineBreak;
            list1.add(linesBuilder);


        }
        set.addAll(list1);
        return list1;
    }
}
