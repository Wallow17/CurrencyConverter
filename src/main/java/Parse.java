import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.io.FileReader;
import java.util.Arrays;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Parse {
    Map<String, Float> map = new HashMap<>();
    String[] tab = null;

    /**
     * @return the map
     */
    public Map<String, Float> getMap() {
        return this.map;
    }

    public String[] get_currency_tab() {
        return this.tab;
    }

    public Parse() {
        JSONParser parser = new JSONParser();
        int i = 0;
        try {
            Object obj = parser.parse(new FileReader("currency.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray tab = (JSONArray) jsonObject.get("currency");
            this.tab = new String[tab.size()];
            for (Object act : tab) {
                String[] cur = act.toString().split(":");
                this.map.put(cur[0], Float.valueOf(cur[1]));
                this.tab[i++] = cur[0];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Float make_conversion(String money, String convert, Float val) {
        Float rst;

        if (money == convert)
            return val;
        rst = val * this.map.get(money);
        rst *= this.map.get(convert);
        return rst;
    }
}