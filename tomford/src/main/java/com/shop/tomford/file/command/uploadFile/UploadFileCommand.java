package com.shop.tomford.file.command.uploadFile;

import com.shop.tomford.common.Cqrs.IRequest;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UploadFileCommand implements IRequest<String>{

  private   MultipartFile file;
}
