package com.gmail.lsetzl.simplemidiwriterwrapper

import javax.sound.midi.{Sequence => JSequence, Track => JTrack}

case class Track(events: Seq[MidiEvent]) {
  def ticks: Long = events.map(_.tick).max

  def toJava(sequence: JSequence): JTrack = {
    val t = sequence.createTrack()
    events.foreach(e => t.add(e.toJava))
    t
  }
}
