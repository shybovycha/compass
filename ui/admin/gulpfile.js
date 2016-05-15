var gulp = require('gulp');
var source = require('vinyl-source-stream'); // Used to stream bundle for further handling
var browserify = require('browserify');
var gutil = require('gulp-util');
var watchify = require('watchify');

var browserifyOptions = Object.assign(watchify.args, {
    entries: './src/App.jsx',
    debug: true,
    extensions: ['.jsx']
});

function bundle(bundler) {
    return function () {
        console.log('Building...');

        return bundler
            .transform("babelify", { presets: ["es2015", "react"] })
            .bundle()
            .on('error', gutil.log)
            .pipe(source('bundle.js'))
            .pipe(gulp.dest('./build'));
    }
}

watcher = watchify(browserify(browserifyOptions));

watcher.on('update', bundle(watcher));

gulp.task('watch', bundle(watcher));
gulp.task('default', bundle(browserify(browserifyOptions)));
