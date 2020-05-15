package com.github.lsetzl.simplemidiwriterwrapper

import java.io.File

import javax.sound.midi.{MidiSystem, Sequence => JSequence}

case class Sequence(resolution: Int, tracks: Seq[Track]) {
  def toJava: JSequence = {
    val s = new JSequence(JSequence.PPQ, resolution)
    tracks.foreach(_.toJava(s))
    s
  }

  def tickLength: Long = tracks.map(_.ticks).max

  def write(path: String): Unit = {
    MidiSystem.write(toJava, 1, new File(path))
  }
}
