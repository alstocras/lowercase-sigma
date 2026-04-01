# σ
*Welcome to real life.*
## Main stuff

Hi! This is a 2D top-down strategy game on a hexagonal grid. With minimalist art and rather simple graphics, this game may not seem very interesting. However, this game uses *real, accurate physics.* And it shall (hopefully) never be outdated, thanks to (hopefully) continuous development! Before any of you make a few teraissues about stuff like "my clock is out of sync" or "i cant go faster than this", have a look at [this](https://dn710607.ca.archive.org/0/items/principleofrelat00eins/principleofrelat00eins.pdf) and *then* see if it's a real bug or not.

Some things to note:
* The graphics in this game are *simple and minimalist*. I shall not have sprites with hyper-realistic art.
* The physics *are* accurate, even though the representation is not. This is a strategy game, not an art showcase.

idk why i wrote all of this when the game doesnt even have *any* kind of physics yet except schwarzschild radius calculation

## Libgdx stuff

A [libGDX](https://libgdx.com/) project generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

This project was generated with a template including simple application launchers and an `ApplicationAdapter` extension that draws libGDX logo.

### Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.
- `ios`: iOS mobile platform using RoboVM.

### Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.
