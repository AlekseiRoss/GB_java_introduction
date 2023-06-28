/* Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть WHERE этого запроса, используя StringBuilder. 
Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Пример данной строки {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow */



public class l2_task_1 {
    public static String sqlQueryFromJson(String json){
        StringBuilder whereClause = new StringBuilder();
        boolean isFirstCondition = true;

        // Удаление начального и конечного символов '{' и '}'
        json = json.substring(1, json.length() - 1);

        // Разделение JSON-строки на отдельные пары ключ-значение
        String[] keyValuePairs = json.split(", ");

        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].replace("\"", "");
            String value = keyValue[1].replace("\"", "");

            if (!value.equals("null")) {
                if (!isFirstCondition) {
                    whereClause.append(" AND ");
                }
                whereClause.append(key).append("=").append(value);
                isFirstCondition = false;
            }
        }

        String sqlQuery = "SELECT * FROM students WHERE " + whereClause.toString();
        return sqlQuery;
    }
    public static void main(String[] args) {
        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        System.out.println(sqlQueryFromJson(json));
    }
}
