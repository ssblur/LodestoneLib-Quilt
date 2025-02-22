package com.sammy.ortus.mixin;


import com.mojang.blaze3d.shader.EffectShader;
import com.mojang.blaze3d.shader.GlslImportProcessor;
import com.sammy.ortus.systems.postprocess.OrtusGlslPreprocessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(EffectShader.class)
public class EffectShaderMixin {
	@ModifyArg(method = "compileShader(Lcom/mojang/blaze3d/shader/ShaderStage$Type;Ljava/lang/String;Ljava/io/InputStream;Ljava/lang/String;)Lcom/mojang/blaze3d/shader/EffectShader;", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/shader/ShaderStage;compileShaderInternal(Lcom/mojang/blaze3d/shader/ShaderStage$Type;Ljava/lang/String;Ljava/io/InputStream;Ljava/lang/String;Lcom/mojang/blaze3d/shader/GlslImportProcessor;)I"), index = 4)
	private static GlslImportProcessor useCustomPreprocessor(GlslImportProcessor org) {
		return new OrtusGlslPreprocessor();
	}
}
