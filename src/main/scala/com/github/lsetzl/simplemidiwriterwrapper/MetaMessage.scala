package com.github.lsetzl.simplemidiwriterwrapper

import javax.sound.midi.{MetaMessage => JMetaMessage, MidiMessage => JMidiMessage}

trait MetaMessage extends MidiMessage {
  val typ: MetaMessage.Typ
  val data: Seq[Int]

  override def toJava: JMidiMessage = new JMetaMessage(typ.value, data.map(_.toByte).toArray, data.length)
}

object MetaMessage {

  abstract class Typ(val value: Int)

  object Typ {

    case object Tempo extends Typ(0x51)

  }

  case class Tempo(value: Int) extends MetaMessage {
    override val typ: Typ = Typ.Tempo
    override val data: Seq[Int] = {
      val m: Int = 60 * 1000000 / value
      Seq(m / 65536, (m % 65536) / 256, m % 256)
    }
  }

}