package com.gmail.lsetzl.simplemidiwriterwrapper

import javax.sound.midi.{MidiMessage => JMidiMessage, SysexMessage => JSysexMessage}

abstract class SysexMessage(data: Seq[Int]) extends MidiMessage {
  override def toJava: JMidiMessage = {
    new JSysexMessage((List(0xf0) ++ data :+ 0xf7).map(_.toByte).toArray, data.length)
  }
}

object SysexMessage {
  case object GMSystemOn extends SysexMessage(List(0x7e, 0x7f, 0x09, 1))
}