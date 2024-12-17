package counter  
import chisel3._  
import chisel3.util._  
import chisel3.stage.ChiselStage  
import chisel3.experimental.FixedPoint  
import chisel3.experimental._
import dsptools.numbers._

class Mac[T <: Data : Ring](genIn : T, genOut: T) extends Module {
    val io = IO(new Bundle {
        val a = Input(genIn)
        val b = Input(genIn)
        val c = Input(genIn)
        val out = Output(genOut)
    })
    io.out := io.a * io.b + io.c
}


object Main {  
  def main(args: Array[String]): Unit = {  
    // 使用 ChiselStage.emitVerilog() 生成 Verilog  
    println(ChiselStage.emitVerilog(new Mac(UInt(4.W), UInt(6.W))))  
    println(ChiselStage.emitVerilog(new Mac(SInt(4.W), SInt(6.W))))  
    println(ChiselStage.emitVerilog(new Mac(FixedPoint(4.W, 3.BP), FixedPoint(6.W, 4.BP))))  
  }  
}
