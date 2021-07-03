package Common;

public class SettingsChecker
{
    public SettingsChecker()
    {}

    public static int prepareDBId(int id)
    {
        return id == 0 ? 1 : id;
    }
}
