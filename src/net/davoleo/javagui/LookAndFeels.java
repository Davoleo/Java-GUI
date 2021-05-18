package net.davoleo.javagui;

public enum LookAndFeels {
    METAL("Java Swing (Metal)", "javax.swing.plaf.metal.MetalLookAndFeel"),
    NIMBUS("MacOS-Style (Nimbus)", "javax.swing.plaf.nimbus.NimbusLookAndFeel"),
    @Deprecated
    MOTIF("CDE/Motif", "com.sun.java.swing.plaf.motif.MotifLookAndFeel"),
    WINDOWS_CLASSIC("Windows", "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel"),
    WINDOWS("Windows Classic", "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

    private final String buttonText;
    private final String canonicalName;

    LookAndFeels(String buttonText, String canonicalName)
    {
        this.buttonText = buttonText;
        this.canonicalName = canonicalName;
    }

    public String getText()
    {
        return buttonText;
    }

    public String getCanonicalName()
    {
        return canonicalName;
    }

    public static LookAndFeels getThemeByText(String text) {
        for (LookAndFeels value : values())
        {
            if (value.getText().equals(text))
                return value;
        }

        return null;
    }
}

