# SimpleMidiWriterWrapper
A thin wrapper of javax.sound.midi (only for writing Standard Midi File).

## Linking
Add to build.sbt:
```
resolvers += "jitpack" at "https://jitpack.io"

libraryDependencies += "com.github.lsetzl" % "simplemidiwriterwrapper" % "0.3.2"
```

## Classes

Sequence, Track, MidiEvent, MidiMessage, ShortMessage, MetaMessage, SysexMessage.

Wrapping javax.sound.midi.*