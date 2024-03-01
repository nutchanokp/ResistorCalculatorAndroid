fastlane documentation
----

# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```sh
xcode-select --install
```

For _fastlane_ installation instructions, see [Installing _fastlane_](https://docs.fastlane.tools/#installing-fastlane)

# Available Actions

## Android

### android test

```sh
[bundle exec] fastlane android test
```

Runs all the tests

### android buildDev

```sh
[bundle exec] fastlane android buildDev
```

Build build APK DEV

### android deploy_beta

```sh
[bundle exec] fastlane android deploy_beta
```

Deploy a new version to the Google Play (Beta)

### android deploy_internal

```sh
[bundle exec] fastlane android deploy_internal
```

Submit a new version to the internal track in the Google Play

### android deploy

```sh
[bundle exec] fastlane android deploy
```

Deploy a new version to the Google Play

### android distributeDev

```sh
[bundle exec] fastlane android distributeDev
```

Deploy a Dev app new version to Firebase App Distribution Chanel

----

This README.md is auto-generated and will be re-generated every time [_fastlane_](https://fastlane.tools) is run.

More information about _fastlane_ can be found on [fastlane.tools](https://fastlane.tools).

The documentation of _fastlane_ can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
