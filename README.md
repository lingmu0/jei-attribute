# JEI Attribute

![JEI Attribute cover](cover.png)

Adds Minecraft attributes to JEI's searchable ingredient list.

Supported versions: Minecraft 1.20.1 Forge, Minecraft 1.21.1 NeoForge, and Minecraft 26.1.2 NeoForge.

This branch targets Minecraft 26.1.2 with NeoForge 26.1.2.107 or newer in the 26.1.2 series and Java 25.

## Features

- Search attributes by their translated names.
- Inspect an attribute's description and matching items from JEI's Recipes or Uses view.
- View the current player's attribute value and hover it to see the modifier calculation.
- Browse source items in one cycling slot; Curios item modifiers are included when Curios is installed.
- Attribute descriptions use `<attribute translation key>.desc`, with a localized fallback when no description is present.

JEI is required to use the viewer. Curios is optional and adds support for Curios equipment.

## Dependencies

| Minecraft | Loader | JEI | Curios |
| --- | --- | --- | --- |
| 1.20.1 | Forge | JEI 15 | Curios 5 (optional) |
| 1.21.1 | NeoForge | JEI 19 | Curios 9 (optional) |
| 26.1.2 | NeoForge | JEI 29.43.0.106+ | Curios 15 (optional) |

Install the JAR matching your Minecraft version and loader.

## Build this branch

Use Java 25 and run `./gradlew build` (Windows: `gradlew.bat build`). The release JAR is generated in `build/libs/`.

Source branches: `mc-1.20.1`, `mc-1.21.1`, and `mc-26.1.2-neoforge`.
