package com.example.nozzle;

// TODO: validate color against material — each Material should expose its allowed DetailColors
//       (e.g. Material.allowedColors()), the order form should offer only colors valid for the chosen material,
//       and the service must reject invalid material+color combinations.
//       Later: move to DB, based on executors' actual filament stock.
public enum DetailColor {
    BLACK,
    WHITE,
    GRAY,
    ORANGE,
    BLUE,
    GREEN
}