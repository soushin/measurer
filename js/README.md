# Measurer Sample Js

## run

1: clean

```
$ cd $PROJECT_ROOT
$ ./gradlew js:clean
```

2: build

```
$ cd $PROJECT_ROOT
$ ./gradlew js:build
```

after building occur error below:

```
ERROR in $PROJECT_ROOT/measurer/js/build/node_modules_imported/kotlinx-io/kotlinx-io.js
Module not found: Error: Can't resolve 'text-encoding' in '$PROJECT_ROOT/js/build/node_modules_imported/kotlinx-io'
 @ $PROJECT_ROOT/js/build/node_modules_imported/kotlinx-io/kotlinx-io.js 7910:21-45 7978:21-45
 @ $PROJECT_ROOT/js/build/node_modules_imported/ktor-http/ktor-http.js
 @ $PROJECT_ROOT/mpp_sample/build/classes/kotlin/js/main/mpp_sample.js
 @ ./js.js
```

see [issue]()https://github.com/ktorio/ktor/issues/961).

3: npm install

```
$ cd $PROJECT_ROOT/js/build
$ npm install text-encoding
```

4: build again

```
$ cd $PROJECT_ROOT
$ ./gradlew js:build
$ open js/src/main/web/index.html
```

