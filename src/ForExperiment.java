import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mirshe on 13.03.2018.
 */
public class ForExperiment {
    public static void main(String[] args) {
String s = "до 40% высококачественного мяса\nНет пшеницы, сои, ГМО\nСбалансированное содержание минеральных веществ\nС добавлением вкуснейшего соуса из куриной печени по уникальной технологии                                                                                Содержит пребиотики для улучшения пищеварения           \nСодержит полезные травы, которые имеют очищающие, противовоспалительные, антиоксидантные свойства        Сбалансированное содержание растворимой и нерастворимой клетчатки для избавления от комков шерсти\n";
        System.out.println(s.split("\n")[4]);
    }
}
