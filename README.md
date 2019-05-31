# SimpleMidiWriterWrapper
A thin wrapper of javax.sound.midi (only for writing Standard Midi File).

## Linking
Add to build.sbt:
```
resolvers += "SimpleMidiWriterWrapper" at "https://lsetzl.github.io/SimpleMidiWriterWrapper/repository"

libraryDependencies += "lsetzl" % "simplemidiwriterwrapper_2.12" % "0.2"
```

## Classes

Sequence, Track, MidiEvent, MidiMessage, ShortMessage, MetaMessage, SysexMessage.

Wrapping javax.sound.midi.*
